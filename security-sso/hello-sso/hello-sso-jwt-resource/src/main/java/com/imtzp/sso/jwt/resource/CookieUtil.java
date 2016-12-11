package com.imtzp.sso.jwt.resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.WebUtils;

public class CookieUtil {

	public static void create(HttpServletResponse httpServletResponse, String name, String value, boolean secure,
			Integer maxAge, String domain) {
		Cookie cookie = new Cookie(name, value);
		cookie.setSecure(secure);

		/**
		 * 使JavaScript不可见
		 */
		cookie.setHttpOnly(true);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		
		/**
		 * 所有的路径都可见
		 */
		cookie.setPath("/");

		httpServletResponse.addCookie(cookie);
	}

	public static void clear(HttpServletResponse httpServletResponse, String name) {
		Cookie cookie = new Cookie(name, null);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(0);
		httpServletResponse.addCookie(cookie);
	}

	public static String getValue(HttpServletRequest httpServletRequest, String name) {

		Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
		return cookie != null ? cookie.getValue() : null;
	}
}
