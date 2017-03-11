package com.imtzp.axon3.eventhandlers;

import org.axonframework.eventhandling.EventHandler;

import com.imtzp.axon3.events.MessageCreatedEvent;
import com.imtzp.axon3.events.MessageReadEvent;

public class MessagesEventHandler {

	@EventHandler
	public void handle(MessageCreatedEvent event) {
		System.out.println("Message received: " + event.getText() + " (" + event.getId() + ")");
	}

	@EventHandler
	public void handle(MessageReadEvent event) {
		System.out.println("Message read: " + event.getId());
	}
}
