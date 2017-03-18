package com.imtzp.multiversion.demo1.rest.v2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imtzp.multiversion.demo1.model.v2.Actor;


@RestController(value = "actorResourceV2")
@RequestMapping(produces = "application/json")
public class ActorResource {

	@GetMapping(value = "/v2/actors/{id}")
	public Actor getActorVersion2InUrl(@PathVariable("id") String id, HttpServletRequest request) {
		return this.buildV2Actor(id, request.getServerName(), String.valueOf(request.getServerPort()));
	}

	@GetMapping(value = "/actors/{id}", consumes = "application/vnd.asimio-v2+json")
	public Actor getActorVersion2InAcceptHeader(@PathVariable("id") String id) {
		return this.buildV2Actor(id);
	}

	private Actor buildV2Actor(String id) {
		return this.buildV2Actor(id, String.format("First%s", id), String.format("Last%s", id));
	}

	private Actor buildV2Actor(String id, String firstName, String lastName) {

		Actor result = new Actor();
		result.setId(id);
		result.setFirst(firstName);
		result.setLast(lastName);

		return result;
	}
}
