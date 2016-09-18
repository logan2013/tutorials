package com.imtzp.si.consume;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
	TopicExchange worksExchange() {
		return new TopicExchange("work.exchange", true, false);
	}

	@Bean
	Queue worksQueue() {
		return new Queue("work.queue", true);
	}

	@Bean
	Binding rubeExchangeBinding(TopicExchange worksExchange, Queue worksQueue) {
		return BindingBuilder.bind(worksQueue).to(worksExchange).with("#");
	}
}
