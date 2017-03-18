package com.imtzp.multiversion.demo2.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { "com.imtzp.multiversion.demo2.config",
		"com.imtzp.multiversion.demo2.rest" })
@EnableEurekaClient
public class DemoMultiversionRegistrationApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMultiversionRegistrationApi2Application.class, args);
	}
}
