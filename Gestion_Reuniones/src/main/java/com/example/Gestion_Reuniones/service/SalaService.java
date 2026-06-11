package com.example.Gestion_Reuniones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Reuniones.models.entities.Sala;
import com.example.Gestion_Reuniones.models.request.ActualizarSala;
import com.example.Gestion_Reuniones.models.request.AgregarSala;
import com.example.Gestion_Reuniones.repository.SalaRepository;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> obtenerTodasLasSalas() {
        return salaRepository.findAll();
    }


    public Sala obtenerSalaPorId(int id_sala){
        Sala sala = salaRepository.findById(id_sala).orElse(null);
        if (sala == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sala no encontrada con esa id");
        }
        return sala;
    }

    public Sala agregarSala(AgregarSala nueva){
        Sala salaNueva = new Sala();
        salaNueva.setPiso(nueva.getPiso());
        return salaRepository.save(salaNueva);
    }

    public Sala actualizarSala(ActualizarSala nuevaSala){
        Sala sala = salaRepository.findById(nuevaSala.getId_sala()).orElse(null);
        if (sala == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sala no encontrada con esa id");
        }
        sala.setPiso(nuevaSala.getPiso());
        return salaRepository.save(sala);
    }


    public String eliminarSala(int id_sala){
        if (salaRepository.existsById(id_sala)){
            salaRepository.deleteById(id_sala);
            return "Sala eliminada correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Sala no encontrada con esa id");
        }
    }
    
}
