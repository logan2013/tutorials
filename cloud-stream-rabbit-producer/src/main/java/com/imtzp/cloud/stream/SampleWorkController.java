package com.imtzp.cloud.stream;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleWorkController {

	@Autowired
	private WorkUnitGateway workUnitGateway;

	@GetMapping("/generateWork")
	WorkUnit generateWork(@RequestParam("definition") String definition) {

		WorkUnit sampleWorkUnit = new WorkUnit(UUID.randomUUID().toString(), definition);

		workUnitGateway.generate(sampleWorkUnit);

		return sampleWorkUnit;
	}
}
