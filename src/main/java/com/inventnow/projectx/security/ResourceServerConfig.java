package com.inventnow.projectx.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import static com.inventnow.projectx.security.RoleEnum.CUSTOMER;
import static com.inventnow.projectx.security.RoleEnum.PEX_ADMIN;
import static com.inventnow.projectx.security.RoleEnum.VISITOR;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/**").hasAnyAuthority(PEX_ADMIN.name())
                .antMatchers("/v1/ecoupons/**").hasAnyAuthority(CUSTOMER.name())
                .antMatchers(HttpMethod.POST, "/v1/user/registration").hasAnyAuthority(VISITOR.name(), PEX_ADMIN.name())
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
