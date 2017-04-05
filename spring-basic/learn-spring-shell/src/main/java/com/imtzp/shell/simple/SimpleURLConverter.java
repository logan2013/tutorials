package com.imtzp.shell.simple;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

@Component
public class SimpleURLConverter implements Converter<URL> {

	@Override
	public boolean supports(Class<?> type, String optionContext) {
		return URL.class.isAssignableFrom(type);
	}

	@Override
	public URL convertFromText(String value, Class<?> targetType, String optionContext) {

		try {
			return new URL(value);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean getAllPossibleValues(List<Completion> completions, Class<?> targetType, String existingData,
			String optionContext, MethodTarget target) {
		return false;
	}

}
