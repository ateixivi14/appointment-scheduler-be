package com.training.scheduler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQSender {

    private final AmqpTemplate amqpTemplate;

    @Scheduled(cron = "0 0 6 * * *")
    public void send() {
        String customMessage = "This is a sample message";
        amqpTemplate.convertAndSend(customMessage);
        System.out.println(customMessage);
    }
}
