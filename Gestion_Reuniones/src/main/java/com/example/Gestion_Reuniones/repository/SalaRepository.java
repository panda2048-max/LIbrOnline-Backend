package com.example.Gestion_Reuniones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion_Reuniones.models.entities.Sala;
@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
    
}
