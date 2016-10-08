package com.imtzp.client.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class Oauth2ClientPasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ClientPasswordApplication.class, args);
	}
}
