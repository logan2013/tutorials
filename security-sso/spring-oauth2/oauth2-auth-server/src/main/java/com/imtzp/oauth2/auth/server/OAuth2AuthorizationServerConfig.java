package com.imtzp.oauth2.auth.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Override
    public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		/**
		 * 如果不配置，默认是denyAll，不能继续
		 */
		oauthServer.checkTokenAccess("isAuthenticated()");
    }
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()

				.withClient("sampleClientId").secret("secret").authorizedGrantTypes("authorization_code").scopes("read", "write")
				.accessTokenValiditySeconds(3600);
	}
}
