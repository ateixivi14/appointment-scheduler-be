package com.training.scheduler.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime appointmentDate;
    
    private String appointmentDescription;
    
    private String appointmentName;

    private String username;

    private boolean hasNotification;

}
