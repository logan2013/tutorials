package com.imtzp.axon3.aggregates;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;

import com.imtzp.axon3.commands.CreateMessageCommand;
import com.imtzp.axon3.commands.MarkReadMessageCommand;
import com.imtzp.axon3.events.MessageCreatedEvent;
import com.imtzp.axon3.events.MessageReadEvent;

public class MessagesAggregate {

	@AggregateIdentifier
	private String id;

	public MessagesAggregate() {
	}

	@CommandHandler
	public MessagesAggregate(CreateMessageCommand command) {
		apply(new MessageCreatedEvent(command.getId(), command.getText()));
	}

	@EventHandler
	public void on(MessageCreatedEvent event) {
		this.id = event.getId();
	}

	@CommandHandler
	public void markRead(MarkReadMessageCommand command) {
		apply(new MessageReadEvent(this.id));
	}
}
