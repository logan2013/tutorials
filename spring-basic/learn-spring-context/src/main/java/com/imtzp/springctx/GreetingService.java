package com.imtzp.springctx;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	private static final Logger logger = Logger.getLogger(GreetingService.class.getName());

	public void greet() {
		logger.info("Gaurav Bytes welcomes you for your first tutorial on Spring!!!");
	}
}
