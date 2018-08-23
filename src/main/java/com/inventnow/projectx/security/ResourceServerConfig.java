package com.inventnow.projectx.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import static com.inventnow.projectx.security.RoleEnum.PEX_ADMIN;
import static com.inventnow.projectx.security.RoleEnum.PEX_CUSTOMER;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/ecoupons/**").hasAnyAuthority(PEX_CUSTOMER.name(),PEX_ADMIN.name())
                .antMatchers("/v1/user/**").hasAnyAuthority(PEX_ADMIN.name())
                .antMatchers("/auth/info").permitAll()
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
