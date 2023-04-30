package com.training.notifier.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifier")
@RequiredArgsConstructor
public class NotifierController {

    private final RabbitMQConsumer rabbitMQConsumer;

    @GetMapping
    public void getMessageFromQueue(){

    }


}
