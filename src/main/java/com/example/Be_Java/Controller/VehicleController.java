package com.example.Be_Java.Controller;

import com.example.Be_Java.Dto.ResponseBodyDto;
import com.example.Be_Java.Entity.Vehicle;
import com.example.Be_Java.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;


    @GetMapping("/page")
    public ResponseBodyDto<Page<Vehicle>> getVehiclePage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return vehicleService.getVehiclePage(pageable);
    }
}
