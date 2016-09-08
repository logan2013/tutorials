package com.imtzp.servlet3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc)
			throws IOException, ServletException {

		System.out.println("---------Filter----------");

		fc.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {

	}

}
