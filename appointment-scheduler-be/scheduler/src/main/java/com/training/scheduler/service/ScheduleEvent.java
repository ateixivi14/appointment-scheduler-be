package com.training.scheduler.service;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@Data
@Builder
public class ScheduleEvent implements Serializable {

    private final String message;
    private final String userName;
    private final String description;
}
