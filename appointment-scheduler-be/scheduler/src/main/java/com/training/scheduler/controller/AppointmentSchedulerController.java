package com.training.scheduler.controller;

import com.training.scheduler.service.AppointmentRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentSchedulerController {
    
    private final AppointmentRegisterService appointmentRegisterService;
    
    @PostMapping
    public void registerEvent(@RequestBody RegisterAppointmentRequest eventRequest) {
        appointmentRegisterService.registerAppointment(eventRequest);
    }
}
