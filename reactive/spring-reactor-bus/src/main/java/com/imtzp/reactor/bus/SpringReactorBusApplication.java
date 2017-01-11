package com.imtzp.reactor.bus;

import static reactor.bus.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.Environment;
import reactor.bus.EventBus;

@SpringBootApplication
public class SpringReactorBusApplication implements CommandLineRunner {

	@Autowired
	private EventBus eventBus;

	@Autowired
	private NotificationConsumer notificationConsumer;

	@Bean
	Environment env() {
		return Environment.initializeIfEmpty().assignErrorJournal();
	}
	
	/**
	 * 创建EventBus，使用默认的线程池
	 * 
	 * @param env
	 * @return
	 */
	@Bean
	EventBus createEventBus(Environment env) {
		return EventBus.create(env, Environment	.THREAD_POOL);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringReactorBusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		eventBus.on($("notificationConsumer"), notificationConsumer);
	}
}
