package com.example.Creacion_Eventos.controller;

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

import com.example.Creacion_Eventos.models.entities.Calendario;
import com.example.Creacion_Eventos.models.request.ActualizarCalendario;
import com.example.Creacion_Eventos.models.request.AgregarCalendario;
import com.example.Creacion_Eventos.service.CalendarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    @Autowired
    private CalendarioService calendarioService;

    @GetMapping
    public List<Calendario> obtenerTodosLosCalendarios() {

        return calendarioService.obtenerTodosLosCalendarios();
    }

    @GetMapping("/{id_calendario}")
    public Calendario obtenerCalendarioPorId(
            @PathVariable int id_calendario) {

        return calendarioService
            .obtenerCalendarioPorId(id_calendario);
    }

    @PostMapping
    public Calendario agregarCalendario(
            @Valid @RequestBody
            AgregarCalendario nuevoCalendario) {

        return calendarioService
            .agregarCalendario(nuevoCalendario);
    }

    @PutMapping
    public Calendario actualizarCalendario(
            @Valid @RequestBody
            ActualizarCalendario actualizarCalendario) {

        return calendarioService
            .actualizarCalendario(actualizarCalendario);
    }

    @DeleteMapping("/{id_calendario}")
    public String eliminarCalendario(
            @PathVariable int id_calendario) {

        return calendarioService
            .eliminarCalendario(id_calendario);
    }
}