package com.imtzp.springdi;

import java.io.File;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.imtzp.springdi.config.ConstructorBasedDIConfig;
import com.imtzp.springdi.constructor.ConstructorBasedFileParser;

public class ConstructorBasedApp {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
				ConstructorBasedDIConfig.class);) {
			ConstructorBasedFileParser parser = context.getBean(ConstructorBasedFileParser.class);
			parser.parseFile(new File("text.json"));
		}
	}
}
