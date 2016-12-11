package com.imtzp.authorization_code.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@EnableOAuth2Sso
@SpringBootApplication
public class Oauth2AuthorizationCodeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthorizationCodeClientApplication.class, args);
	}
}
