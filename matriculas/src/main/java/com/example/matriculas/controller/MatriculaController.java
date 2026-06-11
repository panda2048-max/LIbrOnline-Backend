package com.example.matriculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.matriculas.models.entities.Matriculas;
import com.example.matriculas.models.request.Actualizar_matricula;
import com.example.matriculas.models.request.Agregar_matricula;
import com.example.matriculas.services.MatriculaServices;

@RequestMapping("matricula")
@RestController
public class MatriculaController {
    
    @Autowired
    private MatriculaServices matriculaServices;

    @GetMapping("")
    public List<Matriculas> obtenerTodaslasMatriculas() {
        return matriculaServices.obtenerTodasLasMatriculas();
    }

    @GetMapping("/{id_matriculas}")
    public Matriculas obtenerMatriculasPorId(@PathVariable int id_matriculas) {
        return matriculaServices.obtenerMatriculasPorId(id_matriculas);
    }
    
    @PostMapping("")
    public Matriculas agregarMatriculas(@RequestBody Agregar_matricula nuevaMatricula){
        return matriculaServices.agregarMatriculas(nuevaMatricula);
    }
    
    @PutMapping("")
    public Matriculas actualizarMatriculas(@RequestBody Actualizar_matricula actualizar){ // JSON → DTO
        return matriculaServices.actualizMatriculas(actualizar);
    }

    @DeleteMapping("/{id_matriculas}")                    
    public String eliminarMatricula(@PathVariable int id_matricula){ 
        return matriculaServices.eliminarMatriculas(id_matricula); 
    }
}
