package com.example.Be_Java.Dto;

import com.example.Be_Java.Entity.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.UUID;

@Data
public class DM_StatusDto {


    private UUID id;
    @Enumerated(EnumType.STRING)
    private Status inStatus;
    @Enumerated(EnumType.STRING)
    private Status outStatus;
    private VehicleDto vehicleDto;
}
