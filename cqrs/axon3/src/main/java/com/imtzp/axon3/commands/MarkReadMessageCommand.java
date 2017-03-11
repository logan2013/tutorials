package com.imtzp.axon3.commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class MarkReadMessageCommand {

	/**
	 * 告诉axon id字段是给定aggregate的id
	 */
	@TargetAggregateIdentifier
	private final String id;

	public MarkReadMessageCommand(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
