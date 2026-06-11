package com.example.Gestion_Reuniones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion_Reuniones.models.entities.Reunion;

@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Integer> {
    
}
