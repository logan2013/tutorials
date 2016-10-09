package com.imtzp.resource.server;

import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

//@Configuration
//@EnableResourceServer
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuth2ResourceServerJdbcConfig extends GlobalMethodSecurityConfiguration {

//	@Override
//	protected MethodSecurityExpressionHandler createExpressionHandler() {
//		return new OAuth2MethodSecurityExpressionHandler();
//	}
//
//	@Autowired
//	private Environment env;
//
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//		dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.user"));
//		dataSource.setPassword(env.getProperty("jdbc.pass"));
//		return dataSource;
//	}
//
//	@Bean
//	public TokenStore tokenStore() {
//		return new JdbcTokenStore(dataSource());
//	}
}
