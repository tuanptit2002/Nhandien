package com.example.Be_Java.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class DM_Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Status inStatus;
    @Enumerated(EnumType.STRING)
    private Status outStatus;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}
