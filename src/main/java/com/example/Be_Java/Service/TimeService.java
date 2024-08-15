package com.example.Be_Java.Service;

import com.example.Be_Java.Dto.ResponseBodyDto;
import com.example.Be_Java.Entity.Time;
import com.example.Be_Java.Repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TimeService {


    @Autowired
    TimeRepository timeRepository;

    public ResponseBodyDto<Time> create(Time time){
        Time timeSave =  timeRepository.save(time);
        return new ResponseBodyDto<>(timeSave, "OK", "200");
    }

    public ResponseBodyDto<Time> getByVehicle(String vehicle_id){
        Time timeSave =  timeRepository.getByVehicle(UUID.fromString(vehicle_id));
        return new ResponseBodyDto<>(timeSave, "OK", "200");
    }
}
