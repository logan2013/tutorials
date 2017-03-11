package com.imtzp.axon3.events;

public class MessageCreatedEvent {

	private final String id;
	private final String text;

	public MessageCreatedEvent(String id, String text) {
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
