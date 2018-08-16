package com.inventnow.projectx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringSwaggerConfig {

    public static final String CODENAME = "projectx";
    public static final String HOSTPROJECT = "http://pex-api.com";

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.inventnow.projectx"))
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "PEX-API",
                "PEX API v1 Docs",
                "V1",
                "TERMS OF SERVICE URL",
                new Contact(CODENAME, HOSTPROJECT,"bedhes-pex@mail.com"),
                "LICENSE",
                "LICENSE URL",
                java.util.Collections.EMPTY_LIST
        );
    }
}
