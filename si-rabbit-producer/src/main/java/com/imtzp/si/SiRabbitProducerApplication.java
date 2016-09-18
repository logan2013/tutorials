package com.imtzp.si;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.annotation.IntegrationComponentScan;

@SpringBootApplication
@IntegrationComponentScan
public class SiRabbitProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiRabbitProducerApplication.class, args);
	}
}
