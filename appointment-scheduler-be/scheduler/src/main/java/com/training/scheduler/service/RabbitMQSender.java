package com.training.scheduler.service;

import com.training.scheduler.domain.Appointment;
import com.training.scheduler.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;

    private final AppointmentRepository appointmentRepository;

    //@Scheduled(cron = "0 0 6 * * *")
    @Scheduled(fixedRate = 10000)
    public void send() {
        List<Appointment> appointmentList = appointmentRepository.findAll().stream().filter(Appointment::isSendNotification).toList();
        appointmentList.stream().forEach(appointment -> sendScheduleEvent(appointment));
    }

    private void sendScheduleEvent(Appointment appointment) {
        ScheduleEvent event = ScheduleEvent.builder()
                .description(appointment.getDescription())
                .userName(appointment.getUsername())
                .message("Sended Scheduled event for appointment: " + appointment.getId().toString()).build();
        rabbitTemplate.convertAndSend("internal.exchange","internal.notification.routing-key", event);
        appointment.setSendNotification(false);
        appointmentRepository.save(appointment);
    }

}
