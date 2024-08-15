package com.example.Be_Java.Repository;

import com.example.Be_Java.Entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TimeRepository extends JpaRepository<Time, String> {
    @Query(value = "select * from time t where t.vehicle_id = :vehicle_id", nativeQuery = true)
    public Time getByVehicle(UUID vehicle_id);
}
