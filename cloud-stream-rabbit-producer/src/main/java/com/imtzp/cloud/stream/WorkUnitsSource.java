package com.imtzp.cloud.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface WorkUnitsSource {

	String CHANNEL_NAME = "worksChannel";

	@Output
	MessageChannel worksChannel();
}
