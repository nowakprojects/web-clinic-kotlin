package com.github.nowakprojects.webclinicbackend.global.configuration.oauth2

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

@Configuration
@EnableResourceServer
class OAuth2ResourceServerConfig : ResourceServerConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.cors().and().
                authorizeRequests()
                .antMatchers("/", "/user/**", "/console/**", "/swagger-ui.html", "/console/*", "/oauth/token")
                .permitAll()
                .antMatchers("/api/v1/medical-visit/**")
                .authenticated()

        http.csrf().disable()
        http.headers().frameOptions().disable()
    }

    @Throws(Exception::class)
    override fun configure(resources: ResourceServerSecurityConfigurer) {
        super.configure(resources)
    }

}