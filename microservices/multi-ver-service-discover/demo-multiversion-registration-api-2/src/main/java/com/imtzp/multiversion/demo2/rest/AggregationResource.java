package com.imtzp.multiversion.demo2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/aggregation", produces = "application/json")
public class AggregationResource {

	private static final String ACTORS_SERVICE_ID_V1 = "demo-multiversion-registration-api1-v1";
	private static final String ACTORS_SERVICE_ID_V2 = "demo-multiversion-registration-api1-v2";

	private RestTemplate loadBalancedRestTemplate;

	@GetMapping(value = "v1/actors/{id}")
	public com.imtzp.multiversion.demo2.model.v1.Actor findActorV1(@PathVariable("id") String id) {

		String url = String.format("http://%s/v1/actors/{id}", ACTORS_SERVICE_ID_V1);
		return this.loadBalancedRestTemplate.getForObject(url, com.imtzp.multiversion.demo2.model.v1.Actor.class, id);
	}

	@GetMapping(value = "v2/actors/{id}")
	public com.imtzp.multiversion.demo2.model.v2.Actor findActorV2(@PathVariable("id") String id) {

		String url = String.format("http://%s/v2/actors/{id}", ACTORS_SERVICE_ID_V2);
		return this.loadBalancedRestTemplate.getForObject(url, com.imtzp.multiversion.demo2.model.v2.Actor.class, id);
	}

	@Autowired
	public void setLoadBalancedRestTemplate(RestTemplate loadBalancedRestTemplate) {
		this.loadBalancedRestTemplate = loadBalancedRestTemplate;
	}
}
