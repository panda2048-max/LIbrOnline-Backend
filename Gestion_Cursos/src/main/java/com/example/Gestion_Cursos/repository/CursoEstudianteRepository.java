package com.example.Gestion_Cursos.repository;

import com.example.Gestion_Cursos.models.entities.CursoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CursoEstudianteRepository extends JpaRepository<CursoEstudiante, Integer> {
    List<CursoEstudiante> findByCursoId(int cursoId);
    List<CursoEstudiante> findByEstudianteId(int estudianteId);
    boolean existsByCursoIdAndEstudianteId(int cursoId, int estudianteId);
}
