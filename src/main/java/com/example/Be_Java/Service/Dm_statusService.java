package com.example.Be_Java.Service;

import com.example.Be_Java.Dto.ResponseBodyDto;
import com.example.Be_Java.Entity.DM_Status;
import com.example.Be_Java.Repository.Dm_statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Dm_statusService {

    @Autowired
    Dm_statusRepository dmStatusRepository;

    public ResponseBodyDto<DM_Status> create(DM_Status dmStatus){
        DM_Status dmStatusSave = dmStatusRepository.save(dmStatus);
        return new ResponseBodyDto<>(dmStatusSave,"OK","200");
    }

    public ResponseBodyDto<DM_Status> getByVehicle(String vehicle_id){
        DM_Status dmStatusSave = dmStatusRepository.getByVehicleId(UUID.fromString(vehicle_id));
        return new ResponseBodyDto<>(dmStatusSave,"OK","200");
    }
}
