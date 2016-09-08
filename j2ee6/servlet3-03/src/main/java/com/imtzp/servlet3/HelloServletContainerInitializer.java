package com.imtzp.servlet3;

import java.util.EnumSet;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes(IHelloHandleType.class)
public class HelloServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> handleTypeClasses, ServletContext ctx) throws ServletException {

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

		handleTypeClasses.forEach(clazz -> {

			try {
				IHelloHandleType helloHandleType = (IHelloHandleType) clazz.newInstance();
				helloHandleType.onStartup();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
