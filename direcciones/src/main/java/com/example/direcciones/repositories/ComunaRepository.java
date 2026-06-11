package com.example.direcciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.direcciones.models.entities.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
   
}
