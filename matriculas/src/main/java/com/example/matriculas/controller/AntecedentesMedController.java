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

import com.example.matriculas.models.entities.Antecedentes_medicos;
import com.example.matriculas.models.request.Actualizar_antecedentes_med;
import com.example.matriculas.models.request.Agregar_antecedentes_med;
import com.example.matriculas.services.Antecedentes_med_Services;

@RequestMapping("antecedentes_medicos")
@RestController
public class AntecedentesMedController {

    @Autowired
    private Antecedentes_med_Services antecedentes_med_services;

    @GetMapping("")
    public List<Antecedentes_medicos> obtenerTodoslosAntecedentes() {
        return antecedentes_med_services.obtenerTodasLosAntecedentes();
    }

    @GetMapping("/{id_antecedentes_medicos}")
    public Antecedentes_medicos obtenerAntecedentePorId(@PathVariable int id_antecedentes_medicos) {
        return antecedentes_med_services.obtenerAntecedentesPorId(id_antecedentes_medicos);
    }
    
    @PostMapping("")
    public Antecedentes_medicos agregarAntecedentes_apoderados(@RequestBody Agregar_antecedentes_med nuevoAntecedente){
        return antecedentes_med_services.agregarAntecedente(nuevoAntecedente);
    }
    
    @PutMapping("")
    public Antecedentes_medicos actualizarAntecedentes_medicos(@RequestBody Actualizar_antecedentes_med actualizar){ // JSON → DTO
        return antecedentes_med_services.actualizAntecedente(actualizar);
    }

    @DeleteMapping("/{id_antecedentes_medicos}")                    
    public String eliminarAntecedente(@PathVariable int id_antecedente){ 
        return antecedentes_med_services.eliminarAntecedente(id_antecedente); 
    }
}
