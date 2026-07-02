package com.example.Gestion_Cursos.service;

import com.example.Gestion_Cursos.models.entities.CursoEstudiante;
import com.example.Gestion_Cursos.repository.CursoEstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CursoEstudianteService {

    @Autowired
    private CursoEstudianteRepository repository;

    public List<CursoEstudiante> listarPorCurso(int idCurso) {
        return repository.findByCursoId(idCurso);
    }

    public List<CursoEstudiante> listarPorEstudiante(int idEstudiante) {
        return repository.findByEstudianteId(idEstudiante);
    }

    public CursoEstudiante matricular(int idCurso, int idEstudiante) {
        if (repository.existsByCursoIdAndEstudianteId(idCurso, idEstudiante)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El alumno ya esta matriculado en este curso");
        }
        CursoEstudiante ce = new CursoEstudiante();
        ce.setCursoId(idCurso);
        ce.setEstudianteId(idEstudiante);
        return repository.save(ce);
    }

    public void desmatricular(int id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matricula no encontrada");
        }
        repository.deleteById(id);
    }
}
