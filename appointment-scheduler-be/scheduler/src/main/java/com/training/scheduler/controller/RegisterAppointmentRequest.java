package com.training.scheduler.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterAppointmentRequest {
    
    private String jwtToken;
    
    private LocalDateTime appointmentDate;
    
    private String appointmentDescription;
    
    private String appointmentName;
    
    
}
