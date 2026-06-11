package com.example.matriculas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.matriculas.models.entities.Matriculas;

@Repository
public interface MatriculasRepository  extends JpaRepository<Matriculas, Integer>{

}
