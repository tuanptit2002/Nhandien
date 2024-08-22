package com.example.Be_Java.Controller;

import com.example.Be_Java.Dto.ParkingDto;
import com.example.Be_Java.Dto.ResponseBodyDto;
import com.example.Be_Java.Entity.Parking;
import com.example.Be_Java.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parking")
public class ParkingController {

    @Autowired
    ParkingService parkingService;


    @PostMapping("/create")
    public ResponseBodyDto<Parking> create(@RequestBody ParkingDto parkingDto){
        Parking parking = new Parking();
        parking.setTotal(parkingDto.getTotal());
        parking.setName(parkingDto.getName());
        parking.setNumber_location_moto(parkingDto.getNumber_location_moto());
        parking.setNumber_location_bus(parkingDto.getNumber_location_bus());
        return parkingService.create(parking);
    }


}
