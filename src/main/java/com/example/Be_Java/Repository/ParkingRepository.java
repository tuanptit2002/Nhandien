package com.example.Be_Java.Repository;

import com.example.Be_Java.Entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParkingRepository extends JpaRepository<Parking, UUID> {

    public Optional<Parking> findById(UUID id);
}
