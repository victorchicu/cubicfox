package com.cubicfox.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.core.publisher.Mono;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
    private static final String CONTACT_NAME = "Victor Chicu";
    private static final String CONTACT_URL = "https://www.linkedin.com/in/victorchicu/";
    private static final String CONTACT_EMAIL = "victor.chicu@hotmail.com";
    private static final String API_INFO_TITLE = "Test API";
    private static final String API_INFO_DESCRIPTION = "Test Application";
    private static final String API_INFO_VERSION = "1.0";
    private static final String API_INFO_TERM_OF_SERVICE_URL = "";
    private static final String API_INFO_LICENSE = "";
    private static final String API_INFO_LICENSE_URL = "";
    private static final String AUTHORIZATION_SCOPE = "global";
    private static final String AUTHORIZATION_DESCRIPTION = "Access everything";

    @Bean
    public Docket swagger() {
        Contact contact = new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL);
        ApiInfo apiInfo = new ApiInfo(API_INFO_TITLE, API_INFO_DESCRIPTION, API_INFO_VERSION, API_INFO_TERM_OF_SERVICE_URL, contact, API_INFO_LICENSE, API_INFO_LICENSE_URL, Collections.emptyList());
        AuthorizationScope[] authorizationScopes = {new AuthorizationScope(AUTHORIZATION_SCOPE, AUTHORIZATION_DESCRIPTION)};
        List<SecurityReference> securityReference = Collections.singletonList(new SecurityReference(HttpHeaders.AUTHORIZATION, authorizationScopes));
        SecurityContext securityContext = SecurityContext.builder().securityReferences(securityReference).forPaths(s -> true).build();
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo)
                .securitySchemes(Collections.singletonList(new ApiKey("Authorization", "Authorization", "header")))
                .securityContexts(Collections.singletonList(securityContext))
                .useDefaultResponseMessages(false)
                .select()
                .build()
                .genericModelSubstitutes(Mono.class);
    }
}
