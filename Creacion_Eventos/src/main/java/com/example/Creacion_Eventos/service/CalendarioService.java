package com.example.Creacion_Eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Creacion_Eventos.models.entities.Calendario;
import com.example.Creacion_Eventos.models.entities.Evento;
import com.example.Creacion_Eventos.models.request.ActualizarCalendario;
import com.example.Creacion_Eventos.models.request.AgregarCalendario;
import com.example.Creacion_Eventos.repository.CalendarioRepository;
import com.example.Creacion_Eventos.repository.EventoRepository;

@Service
public class CalendarioService {

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<Calendario> obtenerTodosLosCalendarios() {

        return calendarioRepository.findAll();
    }

    // OBTENER POR ID
    public Calendario obtenerCalendarioPorId(int id_calendario) {

        Calendario calendario = calendarioRepository
            .findById(id_calendario)
            .orElse(null);

        if (calendario == null) {

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Calendario no encontrado"
            );
        }

        return calendario;
    }

    public Calendario agregarCalendario(AgregarCalendario nuevoCalendario) {

        Evento evento = eventoRepository.findById(nuevoCalendario.getId_evento()).orElseThrow(() 
        -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Evento no encontrado"));

        Calendario calendario = new Calendario();

        calendario.setFecha_inicio(
            nuevoCalendario.getFecha_inicio());

        calendario.setFecha_fin(
            nuevoCalendario.getFecha_fin());

        calendario.setEvento(evento);

        return calendarioRepository.save(calendario);
    }


    public Calendario actualizarCalendario(ActualizarCalendario actualizarCalendario) {

        Calendario calendario = calendarioRepository
            .findById(actualizarCalendario.getId_calendario())
            .orElse(null);

        if (calendario == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Calendario no encontrado");
        }


        if (actualizarCalendario.getFecha_inicio() != null) {

            calendario.setFecha_inicio(
                actualizarCalendario.getFecha_inicio());
        }

        // actualizar fecha fin
        if (actualizarCalendario.getFecha_fin() != null) {

            calendario.setFecha_fin(
                actualizarCalendario.getFecha_fin());
        }

        // actualizar evento
        if (actualizarCalendario.getId_evento() != null) {

            Evento evento = eventoRepository
                .findById(actualizarCalendario.getId_evento())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Evento no encontrado"));
            calendario.setEvento(evento);
        }

        return calendarioRepository.save(calendario);
    }

    // ELIMINAR
    public String eliminarCalendario(int id_calendario) {

        if (calendarioRepository.existsById(id_calendario)) {
            calendarioRepository.deleteById(id_calendario);
            return "Calendario eliminado correctamente.";

        } else {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Calendario no encontrado");
        }
    }
}