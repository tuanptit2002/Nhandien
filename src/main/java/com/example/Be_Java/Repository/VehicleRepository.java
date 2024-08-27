package com.example.Be_Java.Repository;

import com.example.Be_Java.Entity.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    @Query(value = "select * from vehicle v where v.license_plate = :license_plate", nativeQuery = true)
    public List<Vehicle> findByLicensePlate(String license_plate);
    @Query(value = "select * from vehicle v inner join dm_status ds on v.id = ds.vehicle_id where v.license_plate  = :license_plate and ds.in_status = 'FALSE' and ds.out_status = 'FALSE' ", nativeQuery = true)
    public Vehicle checkIn(String license_plate);
    @Query(value = "select v.* from vehicle v inner join dm_status ds on v.id = ds.vehicle_id where v.license_plate  = :license_plate and ds.in_status = 'TRUE' and ds.out_status is NULL ", nativeQuery = true)
    public Vehicle checkOut(String license_plate);
    @Query(value = "select * from vehicle", nativeQuery = true)
    Page<Vehicle> getVehiclePage(Pageable pageable);
}
