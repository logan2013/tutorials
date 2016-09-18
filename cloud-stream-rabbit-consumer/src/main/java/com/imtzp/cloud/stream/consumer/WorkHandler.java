package com.imtzp.cloud.stream.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class WorkHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkHandler.class);

	@StreamListener(WorkUnitsSink.CHANNEL_NAME)
	public void process(WorkUnit workUnit) {
		LOGGER.info("Handling work unit - id: {}, definition: {}", workUnit.getId(), workUnit.getDefinition());
	}

}
