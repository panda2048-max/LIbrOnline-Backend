package com.example.matriculas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.matriculas.models.entities.Antecedentes_medicos;

@Repository
public interface AntecedentesMedRepository extends JpaRepository<Antecedentes_medicos,Integer>{
  
} 
