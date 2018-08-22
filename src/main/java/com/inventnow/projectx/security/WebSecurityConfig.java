package com.inventnow.projectx.security;

import com.inventnow.projectx.user.service.PexUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import static com.inventnow.projectx.security.RoleEnum.ADMIN;
import static com.inventnow.projectx.security.RoleEnum.CUSTOMER_DELETE;
import static com.inventnow.projectx.security.RoleEnum.CUSTOMER_READ;
import static com.inventnow.projectx.security.RoleEnum.CUSTOMER_UPDATE;

@Configuration
@EnableOAuth2Client
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private PexUserDetailsServiceImpl userDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**", "/api-docs/**")
                .antMatchers("/actuator/**");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/v1/**").hasAnyAuthority(ADMIN.name())
                .antMatchers(HttpMethod.GET, "/v1/ecoupons/**").hasAnyAuthority(CUSTOMER_READ.name())
                .antMatchers(HttpMethod.PUT, "/v1/ecoupons/**").hasAnyAuthority(CUSTOMER_UPDATE.name())
                .antMatchers(HttpMethod.POST, "/v1/ecoupons/**").hasAnyAuthority(CUSTOMER_UPDATE.name())
                .antMatchers(HttpMethod.DELETE, "/v1/ecoupons/**").hasAnyAuthority(CUSTOMER_DELETE.name())
                .anyRequest().denyAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
