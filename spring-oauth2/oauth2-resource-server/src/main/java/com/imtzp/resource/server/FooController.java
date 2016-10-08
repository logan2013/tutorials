package com.imtzp.resource.server;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

	@PreAuthorize("#oauth2.hasScope('read')")
	@RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")
	Foo findById(@PathVariable long id) {
		return new Foo(Long.parseLong(RandomStringUtils.randomNumeric(2)), RandomStringUtils.randomAlphabetic(4));
	}
}
