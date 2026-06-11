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

import com.example.Gestion_Cursos.models.entities.Asignatura;
import com.example.Gestion_Cursos.models.request.ActualizarAsignatura;
import com.example.Gestion_Cursos.models.request.AgregarAsignatura;
import com.example.Gestion_Cursos.service.AsignaturaService;

@RestController
@RequestMapping("asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping()
    public List<Asignatura> obtenerTodasLasAsignaturas() {
        return asignaturaService.obtenerTodasLasAsignaturas();
    }

    @GetMapping("/{id_asignatura}")
    public Asignatura obtenerAsignaturaPorId(@PathVariable int id_asignatura) {
        return asignaturaService.obtenerAsignaturaPorId(id_asignatura);
    }

    @PostMapping("")
    public Asignatura agregarAsignatura(@RequestBody AgregarAsignatura nueva) {
        return asignaturaService.agregarAsignatura(nueva);
    }

    @PutMapping("/{id_asignatura}")
    public Asignatura actualizarAsignatura(@RequestBody ActualizarAsignatura nueva) {
        return asignaturaService.actualizarAsignatura(nueva);
    }

    @DeleteMapping("/{id_asignatura}")
    public String eliminarAsignatura(@PathVariable int id_asignatura) {
        return asignaturaService.eliminarAsignatura(id_asignatura);
    }
}
 