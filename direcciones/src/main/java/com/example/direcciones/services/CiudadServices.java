package com.example.direcciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.direcciones.models.entities.Ciudad;
import com.example.direcciones.models.entities.Region;
import com.example.direcciones.models.request.ActualizarCiudad;
import com.example.direcciones.models.request.AgregarCiudad;
import com.example.direcciones.repositories.CiudadRepository;
import com.example.direcciones.repositories.RegionRepository;

@Service
public class CiudadServices {
    
    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private RegionRepository regionRepository;

    public List<Ciudad> obtenerTodasLasCiudades(){
        return ciudadRepository.findAll();
    }

    public Ciudad obtenerCiudadPorId(int id_ciudad){
        Ciudad ciudad = ciudadRepository.findById(id_ciudad).orElse(null);
        if(ciudad == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ciudad no encontrada");
        }
        return ciudad;
    }

    public Ciudad agregarCiudad(AgregarCiudad nuevaCiudad) {
        Region region = regionRepository.findById(nuevaCiudad.getId_region()).orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Region no encontrada"));
        Ciudad ciudad = new Ciudad();
        ciudad.setNombre_ciudad(nuevaCiudad.getNombre_ciudad());
        ciudad.setRegion(region);
        return ciudadRepository.save(ciudad);
    }

    public String eliminarCiudad(int id_ciudad){
        if(ciudadRepository.existsById(id_ciudad)){
            ciudadRepository.deleteById(id_ciudad);
            return"ciudad eliminada correctamente. ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ciudad no encontrada");
        }
    }

    public Ciudad actualizarCiudad(ActualizarCiudad actualizarCiudad){
        Ciudad ciudad = ciudadRepository.findById(actualizarCiudad.getId_ciudad()).orElse(null);
        if(ciudad == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ciudad no encontrada");
        }else{
            ciudad.setNombre_ciudad(actualizarCiudad.getNombre_ciudad());
            return ciudadRepository.save(ciudad);
        }
    }

}
