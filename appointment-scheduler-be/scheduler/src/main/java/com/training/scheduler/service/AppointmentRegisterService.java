package com.training.scheduler.service;

import com.training.scheduler.controller.RegisterAppointmentRequest;
import com.training.scheduler.domain.Appointment;
import com.training.scheduler.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentRegisterService {
    
    private final AppointmentRepository appointmentRepository;
    
    private final UserJwtValidator userValidator;
    
    private final DateChecker dateChecker;

    private final RabbitMQSender rabbitMQSender;
    
    public void registerAppointment(RegisterAppointmentRequest registerAppointmentRequest) {
        
        if (!dateChecker.isDateValid(registerAppointmentRequest.getAppointmentDate())) {
            throw new InvalidAppointmentDateException();
        }
        
        if (!userValidator.isValidUser(registerAppointmentRequest.getJwtToken())) {
            throw new InvalidJwtTokenException();
        }

        Appointment newAppointment = Appointment.builder()
                .id(1L)
                .appointmentDate(registerAppointmentRequest.getAppointmentDate())
                .description(registerAppointmentRequest.getAppointmentDescription())
                .sendNotification(registerAppointmentRequest.isHasNotification())
                .build();
        
        appointmentRepository.save(newAppointment);
    }
}
