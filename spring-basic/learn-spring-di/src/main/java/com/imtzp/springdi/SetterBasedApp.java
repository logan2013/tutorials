package com.imtzp.springdi;

import java.io.File;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.imtzp.springdi.config.SetterBasedDIConfig;
import com.imtzp.springdi.setter.SetterBasedFileParser;

public class SetterBasedApp {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(
				SetterBasedDIConfig.class);) {
			SetterBasedFileParser parser = context.getBean(SetterBasedFileParser.class);
			parser.parseFile(new File("text.json"));
		}
	}
}
