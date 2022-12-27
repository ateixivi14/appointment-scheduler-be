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

    public void send(String message) {
        String customMessage = "This is a sample message";
        amqpTemplate.convertAndSend(customMessage+ message);
        System.out.println(customMessage);
    }
}