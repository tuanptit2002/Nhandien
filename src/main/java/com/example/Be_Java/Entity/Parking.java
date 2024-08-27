package com.example.Be_Java.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long number_location_moto;
    private Long number_location_bus;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "parking")
    private List<Vehicle> vehicles;
}
