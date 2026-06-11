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

import com.example.matriculas.models.entities.Antecedentes_academicos;
import com.example.matriculas.models.request.Actualizar_antecedentes_acad;
import com.example.matriculas.models.request.Agregar_antecedentes_acad;
import com.example.matriculas.services.Antecedentes_acad_Services;



@RequestMapping("antecedentes_academicos")
@RestController
public class AntecedentesAcadController {
    
    @Autowired
    private Antecedentes_acad_Services antecedentes_acad_Services;

    @GetMapping("")
    public List<Antecedentes_academicos> obtenerTodoslosAntecedentes() {
        return antecedentes_acad_Services.obtenerTodasLosAntecedentes();
    }

    @GetMapping("/{id_antecedentes_academicos}")
    public Antecedentes_academicos obtenerAntecedentePorId(@PathVariable int id_antecedentes_academicos) {
        return antecedentes_acad_Services.obtenerAntecedentesPorId(id_antecedentes_academicos);
    }
    
    @PostMapping("")
    public Antecedentes_academicos agregarAntecedentes_academicos(@RequestBody Agregar_antecedentes_acad nuevoAntecedente){
        return antecedentes_acad_Services.agregarAntecedentes(nuevoAntecedente);
    }
    
    @PutMapping("")
    public Antecedentes_academicos actualizarAntecedentes_academicos(@RequestBody Actualizar_antecedentes_acad actualizar){ // JSON → DTO
        return antecedentes_acad_Services.actualizAntecedente(actualizar);
    }

    @DeleteMapping("/{id_antecedentes_academicos}")                    
    public String eliminarantecedente(@PathVariable int id_antecedente){ 
        return antecedentes_acad_Services.eliminarAntecedente(id_antecedente); 
    }
}
