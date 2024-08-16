package com.example.Be_Java.Service;

import com.example.Be_Java.Dto.ParkingDto;
import com.example.Be_Java.Dto.ResponseBodyDto;
import com.example.Be_Java.Entity.Parking;
import com.example.Be_Java.Repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParkingService {

    @Autowired
    ParkingRepository parkingRepository;

    public ResponseBodyDto<Parking> create(Parking parking){
        Parking  parkingSave = parkingRepository.save(parking);
        return new ResponseBodyDto<>(parkingSave, "OK", "200");
    }
    public ResponseBodyDto<Parking> update(ParkingDto parkingDto){
        Parking parkingNew = new Parking();
        parkingNew.setNumber_location_bus(parkingDto.getNumber_location_bus());
        parkingNew.setNumber_location_moto(parkingDto.getNumber_location_moto());
        parkingNew.setName(parkingDto.getName());
        parkingNew.setTotal(parkingDto.getTotal());
        Parking parkingSaved = parkingRepository.save(parkingNew);
        return new ResponseBodyDto<>(parkingSaved, "OK","200");
    }
    public ResponseBodyDto<Parking> getById(String id_Parking){
        Parking  parking = parkingRepository.findById(UUID.fromString(id_Parking)).get();
        return new ResponseBodyDto<>(parking, "OK", "200");
    }
    public ResponseBodyDto<Parking> getByVehicle_id(String vehicle_id){
        Parking parking = parkingRepository.getByIdVehicle(UUID.fromString(vehicle_id));
        return new ResponseBodyDto<>(parking, "OK","200");
    }
}
