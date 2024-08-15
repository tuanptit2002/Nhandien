package com.example.Be_Java.Repository;

import com.example.Be_Java.Entity.DM_Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface Dm_statusRepository extends JpaRepository<DM_Status, String> {

    @Query(value = "select * from dm_status ds where ds.vehicle_id = :vehicle_id", nativeQuery = true)
    public DM_Status getByVehicleId(UUID vehicle_id);
}
