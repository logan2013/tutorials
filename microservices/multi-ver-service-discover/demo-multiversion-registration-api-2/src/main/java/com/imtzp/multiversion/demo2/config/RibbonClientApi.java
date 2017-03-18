package com.imtzp.multiversion.demo2.config;

public enum RibbonClientApi {

	DEMO_REGISTRATION_API1_V1("demo-multiversion-registration-api-1", "v1"),

	DEMO_REGISTRATION_API1_V2("demo-multiversion-registration-api-1", "v2");

	public final String serviceId;
	public final String version;

	private RibbonClientApi(String serviceId, String version) {
		this.serviceId = serviceId;
		this.version = version;
	}

}
