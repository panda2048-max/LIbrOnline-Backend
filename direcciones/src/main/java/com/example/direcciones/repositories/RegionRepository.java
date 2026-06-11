package com.example.direcciones.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.direcciones.models.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
   
}