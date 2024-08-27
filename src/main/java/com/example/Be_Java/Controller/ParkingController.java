package com.example.Be_Java.Controller;

import com.example.Be_Java.Dto.ParkingDto;
import com.example.Be_Java.Dto.ResponseBodyDto;
import com.example.Be_Java.Entity.Parking;
import com.example.Be_Java.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PutMapping("/update")
    public  ResponseBodyDto<Parking> update(@RequestBody ParkingDto parkingDto){
        return parkingService.update(parkingDto);
    }

    @GetMapping("/{id}")
    public ResponseBodyDto<Parking> getById(@PathVariable String id){
        return parkingService.getById(id);
    }

    @GetMapping("/page")
    public ResponseBodyDto<Page<Parking>> getParkingPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page,size);
        return parkingService.getParkingPage(pageable);
    }
}
