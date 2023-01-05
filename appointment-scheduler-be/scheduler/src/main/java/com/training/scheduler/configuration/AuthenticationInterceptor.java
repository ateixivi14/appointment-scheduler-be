package com.training.scheduler.configuration;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component
public class AuthenticationInterceptor implements WebRequestInterceptor {

    private static final String AUTHENTICATION_HEADER = "access_token";

    @Override
    public void preHandle(WebRequest request) throws Exception {
        AuthenticationContext.setJwtToken(request.getHeader(AUTHENTICATION_HEADER));
        System.out.println("Pre handle, set access token "+ request.getHeader(AUTHENTICATION_HEADER));
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
