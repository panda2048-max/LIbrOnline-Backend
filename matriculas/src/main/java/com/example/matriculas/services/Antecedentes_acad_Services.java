package com.example.matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.entities.Antecedentes_academicos;
import com.example.matriculas.models.entities.Hoja_de_vida;
import com.example.matriculas.models.request.Actualizar_antecedentes_acad;
import com.example.matriculas.models.request.Agregar_antecedentes_acad;
import com.example.matriculas.repositories.AntecedentesAcadRepository;
import com.example.matriculas.repositories.HojaVidaRepository;

@Service
public class Antecedentes_acad_Services {
     @Autowired
    private AntecedentesAcadRepository antecedentesAcademicosRepository;

    @Autowired
    private HojaVidaRepository hojaRepository;

    public List<Antecedentes_academicos> obtenerTodasLosAntecedentes(){
        return antecedentesAcademicosRepository.findAll();
    }

    public Antecedentes_academicos obtenerAntecedentesPorId(int id_antecedentes){
        Antecedentes_academicos antecedentes_academicos = antecedentesAcademicosRepository.findById(id_antecedentes).orElse(null);
        if (antecedentes_academicos == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "antecedentes no encontrada");
        }
        return antecedentes_academicos;

    }

    public Antecedentes_academicos agregarAntecedentes(Agregar_antecedentes_acad nuevoAntecedente){
        Hoja_de_vida hoja = hojaRepository.findById(nuevoAntecedente.getId_hoja()).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND,"Hoja de vida no encontrada"));

        Antecedentes_academicos antecedenteNuevo =new Antecedentes_academicos();
        antecedenteNuevo.setLogros_academicos(nuevoAntecedente.getLogros_academicos());
        antecedenteNuevo.setAnno_anterior(nuevoAntecedente.getAnno_anterior());
        antecedenteNuevo.setProm_anno_anterior(nuevoAntecedente.getProm_anno_anterior());
        antecedenteNuevo.setHoja_de_vida(hoja);
        return antecedentesAcademicosRepository.save(antecedenteNuevo);
    }

    public String eliminarAntecedente(int id_antecedente){
        if (antecedentesAcademicosRepository.existsById(id_antecedente)) { 
            antecedentesAcademicosRepository.deleteById(id_antecedente);   
            return "antecedente Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada.");
        }
    }

    public Antecedentes_academicos actualizAntecedente(Actualizar_antecedentes_acad actualizar_antecedentes_acad){
        Antecedentes_academicos antecedentes_academicos = antecedentesAcademicosRepository.findById(actualizar_antecedentes_acad.getId_antecedentes_academicos()).orElse(null);
        if(antecedentes_academicos == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada");
        }else{
        antecedentes_academicos.setLogros_academicos(actualizar_antecedentes_acad.getLogros_academicos());
        antecedentes_academicos.setAnno_anterior(actualizar_antecedentes_acad.getAnno_anterior());
        antecedentes_academicos.setProm_anno_anterior(actualizar_antecedentes_acad.getProm_anno_anterior());
        return antecedentesAcademicosRepository.save(antecedentes_academicos);
        }
    }
}
