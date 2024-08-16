package com.example.Be_Java.Dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TimeDto {

    private UUID id;
    private LocalDateTime time_in;
    private LocalDateTime time_out;


    private VehicleDto vehicle;
}
