package com.training.notifier.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitMQConsumer {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void consume(@Payload ScheduleEvent event) throws JsonProcessingException {
       // String json = "";

     //   json = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println(event.getMessage());

        /*log.info("Received message: {}", json);

        ObjectMapper objectMapper = new ObjectMapper();
        ScheduleEvent dto = objectMapper.readValue(json, ScheduleEvent.class);

        System.out.println(dto.getMessage());*/
    }
}