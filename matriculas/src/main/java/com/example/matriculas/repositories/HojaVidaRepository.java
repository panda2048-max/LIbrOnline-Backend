package com.example.matriculas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.matriculas.models.entities.Hoja_de_vida;

@Repository
public interface HojaVidaRepository  extends JpaRepository <Hoja_de_vida, Integer>{
    
}
