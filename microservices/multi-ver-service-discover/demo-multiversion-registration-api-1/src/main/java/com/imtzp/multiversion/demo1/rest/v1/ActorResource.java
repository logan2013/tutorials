package com.imtzp.multiversion.demo1.rest.v1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imtzp.multiversion.demo1.model.v1.Actor;

@RestController(value = "actorResourceV1")
@RequestMapping(produces = "application/json")
public class ActorResource {

	@GetMapping(value = "/v1/actors/{id}")
	public Actor getActorVersion1InUrl(@PathVariable("id") String id, HttpServletRequest request) {
		return this.buildV1Actor(id, request.getServerName(), String.valueOf(request.getServerPort()));
	}

	@GetMapping(value = "/actors/{id}", consumes = "application/vnd.asimio-v1+json")
	public Actor getActorVersion1InAcceptHeader(@PathVariable("id") String id) {
		return this.buildV1Actor(id);
	}

	private Actor buildV1Actor(String id) {
		return this.buildV1Actor(id, String.format("First%s", id), String.format("Last%s", id));
	}

	private Actor buildV1Actor(String id, String firstName, String lastName) {

		Actor result = new Actor();
		result.setActorId(id);
		result.setFirstName(firstName);
		result.setLastName(lastName);

		return result;
	}
}
