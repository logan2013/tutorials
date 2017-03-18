package com.imtzp.multiversion.demo1.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.imtzp.multiversion.demo1.rest")
@EnableDiscoveryClient
public class DemoMultiversionRegistrationApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoMultiversionRegistrationApi1Application.class, args);
	}
}
