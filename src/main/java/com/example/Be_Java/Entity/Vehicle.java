package com.example.Be_Java.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String license_plate;
    private String vehicle_type;

    @ManyToOne
    @JoinColumn(name = "parking_id")
    private Parking parking;
    @OneToOne(mappedBy = "vehicle")
    private Time time;
    @OneToOne(mappedBy = "vehicle")
    private DM_Status dmStatus;
}
