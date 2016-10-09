package com.imtzp.oauth2.server;

import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * 
 * @author Administrator
 *
 * for jdbc token store
 *
 */
// @Configuration
// @EnableAuthorizationServer
public class AuthServerJdbcConfig extends AuthorizationServerConfigurerAdapter {

//	@Autowired
//	@Qualifier("authenticationManagerBean")
//	private AuthenticationManager authenticationManager;
//
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//
//		// @formatter:off
//		clients.jdbc(dataSource())
//			   .withClient("sampleClientId")
//			   .authorizedGrantTypes("implicit")
//			   .scopes("read")
//			   .autoApprove(true)
//			   .and()
//			   .withClient("fooClientIdPassword")
//			   .secret("secret")
//			   .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//			   .scopes("read");
//		// @formatter:on
//	}
//
//	/**
//	 * in order to use the "password" grant type we need to wire in and use the
//	 * AuthenticationManager bean
//	 * 
//	 * @param endpoints
//	 * @throws Exception
//	 */
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
//	}
//
//	/**
//	 * Use Jdbc to store tokens
//	 * 
//	 * @return
//	 */
//	@Bean
//	public TokenStore tokenStore() {
//		return new JdbcTokenStore(dataSource());
//	}
//
//	@Value("classpath:schema.sql")
//	private Resource resource;
//
//	@Autowired
//	private Environment env;
//
//	@Bean
//	public DataSourceInitializer dataSourceInitializer() {
//		DataSourceInitializer initializer = new DataSourceInitializer();
//		initializer.setDataSource(dataSource());
//		initializer.setDatabasePopulator(databasePopulator());
//
//		return initializer;
//	}
//
//	private DatabasePopulator databasePopulator() {
//
//		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//		populator.addScript(resource);
//
//		return populator;
//	}
//
//	@Bean
//	public DataSource dataSource() {
//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//		dataSource.setUrl(env.getProperty("jdbc.url"));
//		dataSource.setUsername(env.getProperty("jdbc.user"));
//		dataSource.setPassword(env.getProperty("jdbc.pass"));
//
//		return dataSource;
//	}
}
