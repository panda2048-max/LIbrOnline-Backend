package com.example.matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.entities.Antecedentes_apoderados;
import com.example.matriculas.models.entities.Hoja_de_vida;
import com.example.matriculas.models.request.Actualizar_antecedentess_apo;
import com.example.matriculas.models.request.Agregar_antecedentess_apo;
import com.example.matriculas.repositories.AntecedentesApodRepository;
import com.example.matriculas.repositories.HojaVidaRepository;

@Service
public class Antecedentes_apo_services {
    

    @Autowired
    private AntecedentesApodRepository antecedentesApodRepository;

    @Autowired
    private HojaVidaRepository hojaRepository;

    public List<Antecedentes_apoderados> obtenerTodasLosAntecedentes(){
        return antecedentesApodRepository.findAll();
    }

    public Antecedentes_apoderados obtenerAntecedentesPorId(int id_antecedentes){
        Antecedentes_apoderados antecedentes_apoderados = antecedentesApodRepository.findById(id_antecedentes).orElse(null);
        if (antecedentes_apoderados == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "antecedentes no encontrada");
        }
        return antecedentes_apoderados;

    }

     public Antecedentes_apoderados agregarAntecedentes(Agregar_antecedentess_apo nuevo){
        Hoja_de_vida hoja = hojaRepository.findById(nuevo.getId_hoja()).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Hoja de vida no encontrada papito :/"));

        Antecedentes_apoderados antecedente =new Antecedentes_apoderados();
        antecedente.setNivel_academico(nuevo.getNivel_academico());
        antecedente.setNumero_hijos(nuevo.getNumero_hijos());
        antecedente.setEstado_civil(nuevo.getEstado_civil());
        antecedente.setHoja_de_vida(hoja);
        return antecedentesApodRepository.save(antecedente);
    }

    public String eliminarAntecedentes(int id_antecedente){
        if (antecedentesApodRepository.existsById(id_antecedente)) { 
            antecedentesApodRepository.deleteById(id_antecedente);   
            return "antecedente Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada.");
        }
    }

    public Antecedentes_apoderados actualizAntecedente(Actualizar_antecedentess_apo actualizar_antecedentess_apo){
        Antecedentes_apoderados antecedentes_apoderados = antecedentesApodRepository.findById(actualizar_antecedentess_apo.getId_antecedentes_apo()).orElse(null);
        if(antecedentes_apoderados == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada");
        }else{
        antecedentes_apoderados.setNivel_academico(actualizar_antecedentess_apo.getNivel_academico());
        antecedentes_apoderados.setNumero_hijos(actualizar_antecedentess_apo.getNumero_hijos());
        antecedentes_apoderados.setEstado_civil(actualizar_antecedentess_apo.getEstado_civil());
        return antecedentesApodRepository.save(antecedentes_apoderados);
        }
    }
}
