package com.imtzp.client.password;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPostZuulFilter extends ZuulFilter {

	@Autowired
	private ObjectMapper mapper;

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();
		try {
			InputStream is = ctx.getResponseDataStream();
			String responseBody = IOUtils.toString(is, "UTF-8");
			if (responseBody.contains("refresh_token")) {
				Map<String, Object> responseMap = mapper.readValue(responseBody,
						new TypeReference<Map<String, Object>>() {
						});
				String refreshToken = responseMap.get("refresh_token").toString();
				responseMap.remove("refresh_token");
				responseBody = mapper.writeValueAsString(responseMap);

				Cookie cookie = new Cookie("refreshToken", refreshToken);
				cookie.setHttpOnly(true);
				cookie.setSecure(true);
				cookie.setPath(ctx.getRequest().getContextPath() + "/oauth/token");
				cookie.setMaxAge(2592000); // 30 days
				ctx.getResponse().addCookie(cookie);
			}
			ctx.setResponseBody(responseBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	@Override
	public String filterType() {
		return "post";
	}

}
