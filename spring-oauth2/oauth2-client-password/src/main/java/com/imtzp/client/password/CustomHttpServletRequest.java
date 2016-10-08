package com.imtzp.client.password;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomHttpServletRequest extends HttpServletRequestWrapper {

	private Map<String, String[]> additionalParams;
	private HttpServletRequest request;

	public CustomHttpServletRequest(HttpServletRequest request, Map<String, String[]> additionalParams) {
		super(request);

		this.additionalParams = additionalParams;
		this.request = request;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();
		Map<String, String[]> param = new HashMap<>();
		param.putAll(map);
		param.putAll(additionalParams);
		return param;
	}
}
