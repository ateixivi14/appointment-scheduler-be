package com.training.scheduler.service;

import com.nimbusds.jwt.SignedJWT;
import com.training.scheduler.configuration.AuthenticationContext;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class UserJwtValidator {
    
    public boolean isValidUser() throws ParseException {
        var signedJWT = SignedJWT.parse(AuthenticationContext.getJwtToken());
        System.out.println(signedJWT.getJWTClaimsSet().getClaims());
        System.out.println(signedJWT.getPayload().toJSONObject());
        return Boolean.TRUE;
    }
}
