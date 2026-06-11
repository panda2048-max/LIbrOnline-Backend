package com.example.direcciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.direcciones.models.entities.Pais;
import com.example.direcciones.models.entities.Region;
import com.example.direcciones.models.request.ActualizarRegion;
import com.example.direcciones.models.request.AgregarRegion;
import com.example.direcciones.repositories.PaisRepository;
import com.example.direcciones.repositories.RegionRepository;

@Service
public class RegionServices {
    
    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private PaisRepository paisRepository;

    public List<Region> obtenerTodasLasRegiones(){
        return regionRepository.findAll();
    }

    public Region obtenerRegionPorId(int id_region){
        Region region = regionRepository.findById(id_region).orElse(null);
        if(region == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"region no encontrada");
        }
        return region;
    }

    public Region agregarRegion(AgregarRegion nuevoRegion){
        Pais pais = paisRepository.findById(nuevoRegion.getId_pais()).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Pais no encontrado"));
        Region regionNuevo = new Region();
        regionNuevo.setNombre_region(
        nuevoRegion.getNombre_region());
        regionNuevo.setPais(pais);
    return regionRepository.save(regionNuevo);
}

    public String eliminarRegion(int id_region){
        if(regionRepository.existsById(id_region)){
            regionRepository.deleteById(id_region);
            return"region eliminada correctamente. ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"region no encontrada");
        }
    }

    public Region actualizarRegion(ActualizarRegion actualizarRegion){
        Region region= regionRepository.findById(actualizarRegion.getId_region()).orElse(null);
        if(region == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "region no encontrada");
        }else{
            region.setNombre_region(actualizarRegion.getNombre_region());
            return regionRepository.save(region);
        }
    }
}
