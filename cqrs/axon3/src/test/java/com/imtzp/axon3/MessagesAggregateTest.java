package com.imtzp.axon3;

import java.util.UUID;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import com.imtzp.axon3.aggregates.MessagesAggregate;
import com.imtzp.axon3.commands.CreateMessageCommand;
import com.imtzp.axon3.commands.MarkReadMessageCommand;
import com.imtzp.axon3.events.MessageCreatedEvent;
import com.imtzp.axon3.events.MessageReadEvent;

public class MessagesAggregateTest {

	private FixtureConfiguration<MessagesAggregate> fixture;

	@Before
	public void setUp() throws Exception {
		fixture = new AggregateTestFixture<>(MessagesAggregate.class);
	}

	@Test
	public void giveAggregateRoot_whenCreateMessageCommand_thenShouldProduceMessageCreatedEvent() {
		String eventText = "Hello, how is your day?";

		String id = UUID.randomUUID().toString();

		fixture.given().when(new CreateMessageCommand(id, eventText))
				.expectEvents(new MessageCreatedEvent(id, eventText));
	}

	@Test
	public void givenMessageCreatedEvent_whenReadMessageCommand_thenShouldProduceMessageReadEvent() {

		String id = UUID.randomUUID().toString();

		fixture.given(new MessageCreatedEvent(id, "Hello :-)")).when(new MarkReadMessageCommand(id))
				.expectEvents(new MessageReadEvent(id));
	}
}
