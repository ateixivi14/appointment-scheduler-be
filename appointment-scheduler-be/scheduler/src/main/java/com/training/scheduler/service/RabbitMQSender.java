package com.training.scheduler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;

    //@Scheduled(cron = "0 0 6 * * *")
    @Scheduled(fixedRate = 10000)
    public void send() {

        ScheduleEvent event = ScheduleEvent.builder().message("This is a message of an object").build();
        rabbitTemplate.convertAndSend("internal.exchange","internal.notification.routing-key", event);
        System.out.println(event.getMessage());
    }
}
