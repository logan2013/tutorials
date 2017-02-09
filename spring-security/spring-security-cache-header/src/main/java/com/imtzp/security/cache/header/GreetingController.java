package com.imtzp.security.cache.header;

import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	/**
	 * Spring Security默认设置不进行缓存
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/default/users/{name}")
	public ResponseEntity<UserDto> getUserWithDefaultCaching(@PathVariable String name) {

		System.out.println("---------------------getUserWithDefaultCaching get called--------------------");

		return ResponseEntity.ok(new UserDto(name));
	}

	@GetMapping("/custom/users/{name}")
	public ResponseEntity<UserDto> getUserWithCustomCaching(@PathVariable String name) {

		System.out.println("---------------------getUserWithCustomCaching get called--------------------");

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS)).body(new UserDto(name));
	}
}
