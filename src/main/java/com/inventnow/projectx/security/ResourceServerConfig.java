package com.inventnow.projectx.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import static com.inventnow.projectx.security.RoleEnum.ADMIN;
import static com.inventnow.projectx.security.RoleEnum.CUSTOMER;
import static com.inventnow.projectx.security.RoleEnum.MERCHANT_CASHIER;
import static com.inventnow.projectx.security.RoleEnum.MERCHANT_SUPERVISOR;
import static com.inventnow.projectx.security.RoleEnum.VISITOR;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/ecoupons/**").hasAnyAuthority(CUSTOMER.name(), ADMIN.name())
                .antMatchers("/v1/user/admin/**").hasAnyAuthority(ADMIN.name(), MERCHANT_SUPERVISOR.name())
                .antMatchers("/v1/user/signup").hasAnyAuthority(CUSTOMER.name(), ADMIN.name(), VISITOR.name())
                .antMatchers("/v1/user/info").hasAnyAuthority(CUSTOMER.name(), ADMIN.name(), MERCHANT_CASHIER.name(), MERCHANT_SUPERVISOR.name(), VISITOR.name())
                .antMatchers("/v1/merchants/**").hasAnyAuthority(ADMIN.name(), MERCHANT_SUPERVISOR.name())
                .antMatchers(HttpMethod.GET, "/v1/transactions/**").hasAnyAuthority(ADMIN.name(), CUSTOMER.name(), MERCHANT_SUPERVISOR.name())
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
