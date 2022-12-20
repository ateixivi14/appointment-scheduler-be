package com.training.scheduler.controller;

import com.training.scheduler.service.AppointmentRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppointmentSchedulerController {
    
    private final AppointmentRegisterService appointmentRegisterService;
    
    @PostMapping
    public void registerEvent(RegisterAppointmentRequest eventRequest) {
        appointmentRegisterService.registerAppointment(eventRequest);
    }
}
