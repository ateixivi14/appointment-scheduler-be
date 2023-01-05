package com.training.scheduler.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthenticationInterceptorConfiguration implements WebMvcConfigurer {

    private final AuthenticationInterceptor authenticationInterceptor;

    public AuthenticationInterceptorConfiguration(AuthenticationInterceptor authenticationInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(authenticationInterceptor);
    }
}
