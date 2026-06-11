package com.example.matriculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.matriculas.models.entities.Hoja_de_vida;
import com.example.matriculas.models.request.Actualizar_hoja_vida;
import com.example.matriculas.models.request.Agregar_hoja_vida;
import com.example.matriculas.services.Hoja_vida_Services;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("hoja_vida")
@RestController
public class HojaVidaController {
    
    @Autowired
    private Hoja_vida_Services hoja_vida_Services;

    @GetMapping("")
    public List<Hoja_de_vida> obtenerTodaslasHoja_de_vidas() {
        return hoja_vida_Services.obtenerTodasLasHojas();
    }

    @GetMapping("/{id_hoja}")
    public Hoja_de_vida obtenerHojaPorId(@PathVariable int id_hoja) {
        return hoja_vida_Services.obtenerHojasPorId(id_hoja);
    }
    
    @PostMapping("")
    public Hoja_de_vida agregarHoja(@RequestBody Agregar_hoja_vida nuevoHoja){
        return hoja_vida_Services.agregarHoja(nuevoHoja);
    }
    
    @PutMapping("")
    public Hoja_de_vida actualizarHoja(@RequestBody Actualizar_hoja_vida actualizar){ // JSON → DTO
        return hoja_vida_Services.actualizHoja(actualizar);
    }

    @DeleteMapping("/{id_hoja}")                    
    public String eliminarHoja(@PathVariable int id_hoja){ 
        return hoja_vida_Services.eliminarHoja(id_hoja); 
    }
    
}
