package com.example.Be_Java.Dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ParkingDto {


    private UUID id;
    private Long total;
    private Long number_location_moto;
    private Long number_location_bus;
    private String name;


    private List<VehicleDto> vehicles;
}
