package com.example.matriculas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.matriculas.models.entities.Antecedentes_apoderados;

@Repository
public interface AntecedentesApodRepository extends JpaRepository<Antecedentes_apoderados, Integer> {

}
