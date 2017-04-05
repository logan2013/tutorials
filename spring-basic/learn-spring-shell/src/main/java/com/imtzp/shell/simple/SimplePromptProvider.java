package com.imtzp.shell.simple;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimplePromptProvider extends DefaultPromptProvider {

	@Override
	public String getPrompt() {
		return "Logan-shell>";
	}

	@Override
	public String getProviderName() {
		return "Logan Prompt";
	}
}
