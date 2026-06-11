package com.example.Creacion_Eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Creacion_Eventos.models.entities.Evento;
import com.example.Creacion_Eventos.models.request.ActualizarEvento;
import com.example.Creacion_Eventos.models.request.AgregarEvento;
import com.example.Creacion_Eventos.service.EventoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("evento")
public class EventoController {
    

    @Autowired
    private EventoService eventoService;

    @GetMapping("")
    public List<Evento> obtenerTodosLosEventos() {
        return eventoService.obtenerTodosLosEventos();
    }


    @GetMapping("/{id_evento}")
    public Evento obtenerEventoPorId(@PathVariable int id_evento) {
        return eventoService.obtenerEventoPorId(id_evento);
    }

    @PostMapping("")
    public Evento agregarEvento(@RequestBody AgregarEvento nuevoEvento) {
        return eventoService.agregarEvento(nuevoEvento);
    }

    @PutMapping("")
    public Evento actualizarEvento(@RequestBody ActualizarEvento nuevoEvento) {
        return eventoService.actualizarEvento(nuevoEvento);
    }

    @DeleteMapping("/{id_evento}")
    public String eliminarEvento(@PathVariable int id_evento) {
       return eventoService.eliminarEvento(id_evento);
    }
}
