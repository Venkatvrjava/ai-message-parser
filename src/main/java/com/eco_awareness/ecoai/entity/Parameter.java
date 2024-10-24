package com.eco_awareness.ecoai.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Parameter")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parameter;

    private LocalDateTime timestamp;

    public Parameter(String parameter) {
        this.parameter = parameter;
        this.timestamp = LocalDateTime.now();
    }
}
