package com.imtzp.client.password;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class CustomPreZuulFilter extends ZuulFilter {

	@Override
	public Object run() {

		RequestContext ctx = RequestContext.getCurrentContext();

		HttpServletRequest req = ctx.getRequest();
		byte[] encoded;
		try {
			encoded = Base64.encode("fooClientIdPassword:secret".getBytes("UTF-8"));
			ctx.addZuulRequestHeader("Authorization", "Basic " + new String(encoded));

			String refreshToken = extractRefreshToken(req);
			if (refreshToken != null) {
				Map<String, String[]> param = new HashMap<>();
				param.put("refresh_token", new String[] { refreshToken });
				param.put("grant_type", new String[] { "refresh_token" });

				ctx.setRequest(new CustomHttpServletRequest(req, param));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return null;
	}

	private String extractRefreshToken(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equalsIgnoreCase("refreshToken")) {
					return cookies[i].getValue();
				}
			}
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return -2;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
