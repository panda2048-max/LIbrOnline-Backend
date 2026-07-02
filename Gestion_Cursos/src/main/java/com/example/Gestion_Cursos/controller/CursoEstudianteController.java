package com.example.Gestion_Cursos.controller;

import com.example.Gestion_Cursos.models.entities.CursoEstudiante;
import com.example.Gestion_Cursos.service.CursoEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("curso-estudiante")
public class CursoEstudianteController {

    @Autowired
    private CursoEstudianteService service;

    @GetMapping
    public List<CursoEstudiante> listar(
            @RequestParam(required = false) Integer courseId,
            @RequestParam(required = false) Integer studentId) {
        if (courseId != null) return service.listarPorCurso(courseId);
        if (studentId != null) return service.listarPorEstudiante(studentId);
        return List.of();
    }

    @PostMapping
    public CursoEstudiante matricular(@RequestBody Map<String, Integer> body) {
        Integer idCurso = body.get("id_curso");
        Integer idEstudiante = body.get("id_estudiante");
        if (idCurso == null || idEstudiante == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id_curso e id_estudiante son obligatorios");
        }
        return service.matricular(idCurso, idEstudiante);
    }

    @DeleteMapping("/{id}")
    public String desmatricular(@PathVariable int id) {
        service.desmatricular(id);
        return "Alumno desmatriculado";
    }
}
