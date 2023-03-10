package com.training.scheduler.service;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateChecker {
    
    public boolean isDateValid(LocalDateTime date){
        return LocalDateTime.now().isBefore(date);
    }
}
