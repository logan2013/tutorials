package com.imtzp.servlet3;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

@WebListener
public class FilterStartupListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent ce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext ctx = sce.getServletContext();

		/**
		 * 添加Servlet
		 */
		Dynamic dynamic = ctx.addServlet("helloServlet", HelloServlet.class);
		dynamic.addMapping("/hello");

		/**
		 * 添加Filter
		 */
		FilterRegistration.Dynamic dynamicFilter = ctx.addFilter("helloFilter", HelloFilter.class);
		dynamicFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, "/*");
	}

}
