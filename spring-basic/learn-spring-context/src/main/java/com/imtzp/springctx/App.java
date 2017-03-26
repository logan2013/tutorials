package com.imtzp.springctx;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("com.imtzp.springctx");) {
			GreetingService greetingService = context.getBean(GreetingService.class);
			greetingService.greet();
		}
	}
}
