package com.example.Be_Java.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Long total;
    private String name;

    @OneToMany(mappedBy = "parking")
    private List<Vehicle> vehicles;
}
