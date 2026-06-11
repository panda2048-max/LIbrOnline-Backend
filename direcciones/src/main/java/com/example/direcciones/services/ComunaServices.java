package com.example.direcciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.direcciones.models.entities.Ciudad;
import com.example.direcciones.models.entities.Comuna;
import com.example.direcciones.models.request.ActualizarComuna;
import com.example.direcciones.models.request.AgregarComuna;
import com.example.direcciones.repositories.CiudadRepository;
import com.example.direcciones.repositories.ComunaRepository;

@Service
public class ComunaServices {
    
    @Autowired
    private ComunaRepository comunaRepository;

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Comuna> obtenerTodasLasComunas(){
        return comunaRepository.findAll();
    }

    public Comuna obtenerComunaPorId(int id_comuna){
        Comuna comuna = comunaRepository.findById(id_comuna).orElse(null);
        if(comuna == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"comuna no encontrada");
        }
        return comuna;
    }

    public Comuna agregarComuna(AgregarComuna nuevaComuna) {
        Ciudad ciudad = ciudadRepository.findById(nuevaComuna.getId_ciudad()).orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND,"Ciudad no encontrada"));
        Comuna comuna = new Comuna();
        comuna.setNombre_comuna(nuevaComuna.getNombre_comuna());
        comuna.setCiudad(ciudad);
        return comunaRepository.save(comuna);
    }


    public String eliminarComuna(int id_comuna){
        if(comunaRepository.existsById(id_comuna)){
            comunaRepository.deleteById(id_comuna);
            return"comuna eliminada correctamente. ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"comuna no encontrada");
        }
    }

    public Comuna actualizarcComuna(ActualizarComuna actualizarComuna){
        Comuna comuna = comunaRepository.findById(actualizarComuna.getId_comuna()).orElse(null);
        if(comuna == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comuna no encontrada");
        }else{
            comuna.setNombre_comuna(actualizarComuna.getNombre_comuna());
            return comunaRepository.save(comuna);
        }
    }

}
