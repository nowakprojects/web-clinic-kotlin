package com.github.nowakprojects.webclinicbackend.global.configuration.oauth2

import com.github.nowakprojects.webclinicbackend.domain.authentication.service.UserService
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.token.TokenEnhancer

@Configuration
@EnableAuthorizationServer
class OAuth2AuthorizationConfig(
        val userService: UserService,
        val authenticationManager: AuthenticationManager,
        val tokenEnhancer: OAuth2TokenEnhancer
) : AuthorizationServerConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        super.configure(endpoints)
        endpoints.userDetailsService(userService)
                .authenticationManager(authenticationManager)
                .tokenEnhancer(tokenEnhancer)
    }

    @Throws(Exception::class)
    override fun configure(security: AuthorizationServerSecurityConfigurer) {
        super.configure(security)
    }

    //TODO: Implement repository for client applications
    @Throws(Exception::class)
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        super.configure(clients)
        clients.inMemory().withClient("web-app").secret("test1234").accessTokenValiditySeconds(999999)
                .scopes("allmighty").authorizedGrantTypes("password", "refresh_token", "client_credentials")
    }
}