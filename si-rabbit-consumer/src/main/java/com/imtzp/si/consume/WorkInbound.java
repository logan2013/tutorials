package com.imtzp.si.consume;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;
import org.springframework.integration.dsl.support.Transformers;

@Configuration
public class WorkInbound {

	@Bean
	IntegrationFlow inboundFlow(ConnectionFactory connectionFactory, Queue worksQueue) {

		return IntegrationFlows.from(Amqp.inboundAdapter(connectionFactory, worksQueue).concurrentConsumers(3))
				.transform(Transformers.fromJson(WorkUnit.class)).handle("workHandler", "process").get();
	}
}
