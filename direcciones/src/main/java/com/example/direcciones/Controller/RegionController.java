package com.example.direcciones.Controller;

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

import com.example.direcciones.models.entities.Region;
import com.example.direcciones.models.request.ActualizarRegion;
import com.example.direcciones.models.request.AgregarRegion;
import com.example.direcciones.services.RegionServices;

@RequestMapping("region")
@RestController
public class RegionController {
    @Autowired
    private RegionServices regionServices;

    @GetMapping("")
    public List<Region> obtenerTodasLasRegiones() {
        return regionServices.obtenerTodasLasRegiones();
    }
    
    @GetMapping("/{id_region}")
    public Region obtenerRegionPorId(@PathVariable int id_region){
        return regionServices.obtenerRegionPorId(id_region);
    }

    @PostMapping("")
    public Region agregarRegion(@RequestBody AgregarRegion nuevaRegion){ 
        return regionServices.agregarRegion(nuevaRegion);
    }

    @PutMapping("")
    public Region actualizaRegion(@RequestBody ActualizarRegion actualizar) {       
        return regionServices.actualizarRegion(actualizar);
    }
    
    @DeleteMapping("/{id_region}")
    public String eliminarRegion(@PathVariable int id_region){
        return regionServices.eliminarRegion(id_region);
    }
}
