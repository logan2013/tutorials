package com.imtzp.axon3.commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class CreateMessageCommand {

	/**
	 * 告诉Axon id字段是给定的aggregate的id
	 */
	@TargetAggregateIdentifier
	private final String id;

	private final String text;

	public CreateMessageCommand(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}
}
