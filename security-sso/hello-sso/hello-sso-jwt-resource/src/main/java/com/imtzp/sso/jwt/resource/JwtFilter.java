package com.imtzp.sso.jwt.resource;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class JwtFilter extends OncePerRequestFilter {

	private static final String jwtTokenCookieName = "JWT-TOKEN";
	private static final String signingKey = "signingKey";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = JwtUtil.getSubject(request, jwtTokenCookieName, signingKey);
		if (username == null) {
			String authService = this.getFilterConfig().getInitParameter("services.auth");
			response.sendRedirect(authService + "?redirect=" + request.getRequestURL());
		} else {
			request.setAttribute("username", username);
			filterChain.doFilter(request, response);
		}
	}

}
