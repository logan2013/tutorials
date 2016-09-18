package com.imtzp.si;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface WorkUnitGateway {

	@Gateway(requestChannel = "worksChannel")
	void generate(WorkUnit workUnit);
}
