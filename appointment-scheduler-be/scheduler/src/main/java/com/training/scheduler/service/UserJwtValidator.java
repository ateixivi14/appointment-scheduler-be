package com.training.scheduler.service;

import com.nimbusds.jwt.SignedJWT;
import com.training.scheduler.configuration.AuthenticationContext;
import com.training.scheduler.domain.ApiUser;
import com.training.scheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@RequiredArgsConstructor
public class UserJwtValidator {

    private final UserRepository userRepository;
    
    public boolean isValidUser() throws ParseException {
        var signedJWT = SignedJWT.parse(AuthenticationContext.getJwtToken());
        System.out.println(signedJWT.getJWTClaimsSet().getClaims());
        String username = signedJWT.getPayload().toJSONObject().get("sub").toString();
        ApiUser apiUser = userRepository.findByUsername(username);
        return userRepository.existsApiUserByUsername(username);
    }
}
