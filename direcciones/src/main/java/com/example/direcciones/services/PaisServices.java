package com.example.direcciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.direcciones.models.entities.Pais;
import com.example.direcciones.models.request.ActualizarPais;
import com.example.direcciones.models.request.AgregarPais;
import com.example.direcciones.repositories.PaisRepository;

@Service
public class PaisServices {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> obtenerTodosLosPaises(){
        return paisRepository.findAll();
    }

    public Pais obtenerPaisPorId(int id_pais){
        Pais pais = paisRepository.findById(id_pais).orElse(null);
        if(pais == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"pais no encontrada");
        }
        return pais;
    }

    public Pais agregarPais(AgregarPais nuevoPais){
        Pais paisNuevo = new Pais();
        paisNuevo.setNombre_pais(nuevoPais.getNombre_pais());
        return paisRepository.save(paisNuevo);
    }

    public String eliminarPais(int id_pais){
        if(paisRepository.existsById(id_pais)){
            paisRepository.deleteById(id_pais);
            return"Pais eliminado correctamente. ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"pais no encontrado");
        }
    }

    public Pais actualizarPais(ActualizarPais actualizarPais){
        Pais pais= paisRepository.findById(actualizarPais.getId_pais()).orElse(null);
        if(pais == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pais no encontrado");
        }else{
            pais.setNombre_pais(actualizarPais.getNombre_pais());
            return paisRepository.save(pais);
        }
    }
}
