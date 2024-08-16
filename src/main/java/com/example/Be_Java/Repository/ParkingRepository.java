package com.example.Be_Java.Repository;

import com.example.Be_Java.Entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ParkingRepository extends JpaRepository<Parking, UUID> {

    public Optional<Parking> findById(UUID id);

    @Query(value = "select p.* from Parking p inner join vehicle v on v.parking_id = p.id where v.id = :vehicle_id", nativeQuery = true)
    public Parking getByIdVehicle(UUID vehicle_id);
}
