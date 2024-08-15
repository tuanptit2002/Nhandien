package com.example.Be_Java.Service;

import com.example.Be_Java.Dto.ResponseBodyDto;
import com.example.Be_Java.Entity.Vehicle;
import com.example.Be_Java.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    ParkingService parkingService;
    @Autowired
    TimeService timeService;

    public ResponseBodyDto<?> create(Vehicle vehicle){

        Vehicle vehicleNew = vehicleRepository.save(vehicle);
        return new ResponseBodyDto<>(vehicleNew,"OK","200");
    }

    public ResponseBodyDto<Vehicle> checkInParking(String license_plate){
        Vehicle vCheckIn = vehicleRepository.checkIn(license_plate);
        return  new ResponseBodyDto<>(vCheckIn, "OK","200");
    }

    public ResponseBodyDto<Vehicle> checkoutParking(String license_plate){
        Vehicle vCheckOut = vehicleRepository.checkOut(license_plate);
        return  new ResponseBodyDto<>(vCheckOut, "OK","200");
    }

    public ResponseBodyDto<List<Vehicle>> getLicensePlate(String license_plate){

        List<Vehicle> vehicles = vehicleRepository.findByLicensePlate(license_plate);

        return new ResponseBodyDto<>(vehicles, "OK", "200");
    }

}
