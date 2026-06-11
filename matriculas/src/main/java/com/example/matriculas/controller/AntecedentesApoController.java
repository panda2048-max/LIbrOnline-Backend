package com.example.matriculas.controller;

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

import com.example.matriculas.models.entities.Antecedentes_apoderados;
import com.example.matriculas.models.request.Actualizar_antecedentess_apo;
import com.example.matriculas.models.request.Agregar_antecedentess_apo;
import com.example.matriculas.services.Antecedentes_apo_services;

@RequestMapping("antecedentes_apoderados")
@RestController
public class AntecedentesApoController {
    
    @Autowired
    private Antecedentes_apo_services antecedentes_apo_services;

    @GetMapping("")
    public List<Antecedentes_apoderados> obtenerTodoslosAntecedentes() {
        return antecedentes_apo_services.obtenerTodasLosAntecedentes();
    }

    @GetMapping("/{id_antecedentes_apoderados}")
    public Antecedentes_apoderados obtenerAntecedentePorId(@PathVariable int id_antecedentes_apoderados) {
        return antecedentes_apo_services.obtenerAntecedentesPorId(id_antecedentes_apoderados);
    }
    
    @PostMapping("")
    public Antecedentes_apoderados agregarAntecedentes_apoderados(@RequestBody Agregar_antecedentess_apo nuevoAntecedente){
        return antecedentes_apo_services.agregarAntecedentes(nuevoAntecedente);
    }
    
    @PutMapping("")
    public Antecedentes_apoderados actualizarAntecedentes_apoderados(@RequestBody Actualizar_antecedentess_apo actualizar){ // JSON → DTO
        return antecedentes_apo_services.actualizAntecedente(actualizar);
    }

    @DeleteMapping("/{id_antecedentes_apoderados}")                    
    public String eliminarAntecedente(@PathVariable int id_antecedente){ 
        return antecedentes_apo_services.eliminarAntecedentes(id_antecedente); 
    }
}
