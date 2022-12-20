package com.training.scheduler.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    
    private String username;
    
    private String description;
    
    private boolean sendNotification;
    
    private LocalDateTime appointmentDate;

}
