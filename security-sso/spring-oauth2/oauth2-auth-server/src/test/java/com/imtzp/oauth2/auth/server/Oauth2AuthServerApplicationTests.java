package com.imtzp.oauth2.auth.server;

import java.util.Base64;

import org.junit.Test;

public class Oauth2AuthServerApplicationTests {

	@Test
	public void testBase64() {
		System.out.println(new String(Base64.getEncoder().encode(new String("sampleClientId:secret").getBytes())));
	}

}
