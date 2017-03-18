package com.imtzp.multiversion.demo2.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClients(value = {
		@RibbonClient(name = "demo-multiversion-registration-api1-v1", configuration = RibbonConfigDemoApi1V1.class),
		@RibbonClient(name = "demo-multiversion-registration-api1-v2", configuration = RibbonConfigDemoApi1V2.class) })
public class AppConfig {
	
	@Bean(name = "loadBalancedRestTemplate")
	@LoadBalanced
	public RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}
}
