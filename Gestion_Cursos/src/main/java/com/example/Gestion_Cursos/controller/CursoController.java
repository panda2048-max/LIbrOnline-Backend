package com.example.Gestion_Cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion_Cursos.models.entities.Curso;
import com.example.Gestion_Cursos.models.request.ActualizarCurso;
import com.example.Gestion_Cursos.models.request.AgregarCurso;
import com.example.Gestion_Cursos.service.CursoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequestMapping("curso")
@RestController
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Curso> obtenertodosLosCursos(){
        return cursoService.obtenerTodosLosCursos();
    }

    @GetMapping("/{id_curso}")
    public Curso obtenerCursoPorId(@PathVariable int id_curso){
        return cursoService.obtenerCursoPorId(id_curso);
    }

    @PostMapping("")
    public Curso agregarCurso(@RequestBody AgregarCurso nuevo){
        return cursoService.agregarCurso(nuevo);
    }

    @PutMapping("")
    public Curso actualizaCurso(@RequestBody ActualizarCurso nuevoCurso){
        return cursoService.actualizaCurso(nuevoCurso);
    }

    @DeleteMapping("/{id_curso}")
    public String eliminarCurso(@PathVariable int id_curso){
        return cursoService.eliminarCurso(id_curso);
    }
}
