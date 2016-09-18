package com.imtzp.si;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;
import org.springframework.integration.dsl.support.Transformers;

@Configuration
public class WorksOutbound {

	@Bean
	IntegrationFlow toOutboundQueueFlow(RabbitTemplate worksRabbitTemplate) {

		return IntegrationFlows.from("worksChannel").transform(Transformers.toJson())
				.handle(Amqp.outboundAdapter(worksRabbitTemplate)).get();
	}
}
