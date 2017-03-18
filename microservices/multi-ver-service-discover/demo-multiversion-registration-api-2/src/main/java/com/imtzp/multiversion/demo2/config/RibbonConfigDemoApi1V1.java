package com.imtzp.multiversion.demo2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.imtzp.multiversion.demo2.niws.loadbalancer.VersionedNIWSServerListFilter;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerListFilter;

public class RibbonConfigDemoApi1V1 {

	private DiscoveryClient discoveryClient;

	@Bean
	public ServerListFilter<Server> serverListFilter() {
		return new VersionedNIWSServerListFilter<>(discoveryClient, RibbonClientApi.DEMO_REGISTRATION_API1_V1);
	}

	@Autowired
	public void setDiscoveryClient(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}
}
