package com.imtzp.axon3;

import java.util.UUID;

import org.axonframework.commandhandling.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.AnnotationEventListenerAdapter;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;

import com.imtzp.axon3.aggregates.MessagesAggregate;
import com.imtzp.axon3.commands.CreateMessageCommand;
import com.imtzp.axon3.commands.MarkReadMessageCommand;
import com.imtzp.axon3.eventhandlers.MessagesEventHandler;

public class MessagesRunner {

	public static void main(String[] args) throws Exception {

		CommandBus commandBus = new SimpleCommandBus();

		EventStore eventStore = new EmbeddedEventStore(new InMemoryEventStorageEngine());
		EventSourcingRepository<MessagesAggregate> repository = new EventSourcingRepository<>(MessagesAggregate.class,
				eventStore);

		AggregateAnnotationCommandHandler<MessagesAggregate> messagesAggregateAggregateAnnotationCommandHandler = new AggregateAnnotationCommandHandler<>(
				MessagesAggregate.class, repository);
		messagesAggregateAggregateAnnotationCommandHandler.subscribe(commandBus);

		AnnotationEventListenerAdapter annotationEventListenerAdapter = new AnnotationEventListenerAdapter(
				new MessagesEventHandler());
		eventStore.subscribe(eventMessages -> eventMessages.forEach(e -> {
			try {
				annotationEventListenerAdapter.handle(e);
			} catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}));

		CommandGateway commandGateway = new DefaultCommandGateway(commandBus);

		String itemId = UUID.randomUUID().toString();
		commandGateway.send(new CreateMessageCommand(itemId, "Hello, how is your day? :-)"));
		commandGateway.send(new MarkReadMessageCommand(itemId));
		
	}
}
