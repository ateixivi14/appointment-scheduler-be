package com.training.appointmentscheduler.service;

import org.springframework.stereotype.Component;

@Component
public class UserJwtValidator {
    
    public boolean isValidUser(String jwt) {
        
        return Boolean.TRUE;
    }
}
