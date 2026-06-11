package com.example.Gestion_Cursos.controller;

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

import com.example.Gestion_Cursos.models.entities.Docente;
import com.example.Gestion_Cursos.models.request.ActualizarDocente;
import com.example.Gestion_Cursos.models.request.AgregarDocente;
import com.example.Gestion_Cursos.service.DocenteService;

@RestController
@RequestMapping("docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @PostMapping
    public Docente agregarDocente(@RequestBody AgregarDocente nuevo){
        return docenteService.agregarDocente(nuevo);
    }

    @GetMapping
    public List<Docente> obtenerTodosLosDocentes(){
        return docenteService.obtenerTodosLosDocentes();
    }

    @GetMapping("/{id}")
    public Docente obtenerDocentePorId(@PathVariable int id){
        return docenteService.obtenerDocentePorId(id);
    }

    @PutMapping("")
    public Docente actualizaDocente(@RequestBody ActualizarDocente nuevoDocente){
        return docenteService.actualizaDocente(nuevoDocente);
    }

    @DeleteMapping("/{id}")
    public void eliminarDocente(@PathVariable int id){
        docenteService.eliminarDocente(id);
    }
}