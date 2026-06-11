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

import com.example.direcciones.models.entities.Comuna;
import com.example.direcciones.models.request.ActualizarComuna;
import com.example.direcciones.models.request.AgregarComuna;
import com.example.direcciones.services.ComunaServices;


@RequestMapping("comuna")
@RestController
public class ComunaController {
    
    @Autowired
    private ComunaServices comunaServices;

    @GetMapping("")
    public List<Comuna> obtenerTodasLasComunas() {
        return comunaServices.obtenerTodasLasComunas();
    }
    
    @GetMapping("/{id_comuna}")
    public Comuna obtenerComunaPorId(@PathVariable int id_comuna){
        return comunaServices.obtenerComunaPorId(id_comuna);
    }

    @PostMapping("")
    public Comuna agregarComuna(@RequestBody AgregarComuna nuevaComuna){ 
        return comunaServices.agregarComuna(nuevaComuna);
    }

    @PutMapping("")
    public Comuna actualizaComuna(@RequestBody ActualizarComuna actualizar) {       
        return comunaServices.actualizarcComuna(actualizar);
    }
    
    @DeleteMapping("/{id_comuna}")
    public String eliminarComuna(@PathVariable int id_comuna){
        return comunaServices.eliminarComuna(id_comuna);
    }
}
