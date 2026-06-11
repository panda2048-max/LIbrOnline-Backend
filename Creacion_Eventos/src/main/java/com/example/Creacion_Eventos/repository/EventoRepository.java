package com.example.Creacion_Eventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Creacion_Eventos.models.entities.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    
}
