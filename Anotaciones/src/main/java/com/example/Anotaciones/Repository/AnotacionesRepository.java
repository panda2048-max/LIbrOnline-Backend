package com.example.Anotaciones.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Anotaciones.Models.Entities.Anotaciones;

@Repository
public interface AnotacionesRepository extends JpaRepository<Anotaciones, Integer> {

}