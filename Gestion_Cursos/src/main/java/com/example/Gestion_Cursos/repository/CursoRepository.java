package com.example.Gestion_Cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Gestion_Cursos.models.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    
}
