package com.training.notifier.consumer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.messaging.handler.annotation.Payload;

import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
public class ScheduleEvent {

    private final String message;
}
