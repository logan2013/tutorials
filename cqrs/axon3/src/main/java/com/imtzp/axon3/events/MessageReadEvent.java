package com.imtzp.axon3.events;

public class MessageReadEvent {

	private final String id;

	public MessageReadEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
