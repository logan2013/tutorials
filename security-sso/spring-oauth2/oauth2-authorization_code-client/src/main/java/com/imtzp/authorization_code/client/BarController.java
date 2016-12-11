package com.imtzp.authorization_code.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BarController {

	@GetMapping("/bar")
	String bar() {
		return "bar";
	}
}
