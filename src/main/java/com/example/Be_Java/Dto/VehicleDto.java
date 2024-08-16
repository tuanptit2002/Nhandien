package com.example.Be_Java.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class VehicleDto {


    private UUID id;
    private String license_plate;
    private String vehicle_type;


    private ParkingDto parkingDto;

    private TimeDto timeDto;

    private DM_StatusDto dmStatusDto;
}
