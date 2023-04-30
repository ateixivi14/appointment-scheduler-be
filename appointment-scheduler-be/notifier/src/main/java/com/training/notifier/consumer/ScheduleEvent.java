package com.training.notifier.consumer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEvent {

    private String message;
    private String userName;
    private String description;
}
