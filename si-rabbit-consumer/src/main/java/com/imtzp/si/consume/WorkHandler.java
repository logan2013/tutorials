package com.imtzp.si.consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WorkHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkHandler.class);

	public void process(WorkUnit workUnit) {
		LOGGER.info("Handling work unit - id: {}, definition: {}", workUnit.getId(), workUnit.getDefinition());
	}
}
