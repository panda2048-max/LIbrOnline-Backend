package com.example.matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.entities.Antecedentes_medicos;
import com.example.matriculas.models.entities.Hoja_de_vida;
import com.example.matriculas.models.request.Actualizar_antecedentes_med;
import com.example.matriculas.models.request.Agregar_antecedentes_med;
import com.example.matriculas.repositories.AntecedentesMedRepository;
import com.example.matriculas.repositories.HojaVidaRepository;

@Service
public class Antecedentes_med_Services {
    
    @Autowired
    private AntecedentesMedRepository antecedentesMedRepository;

    @Autowired
    private HojaVidaRepository hojaRepository;

    public List<Antecedentes_medicos> obtenerTodasLosAntecedentes(){
        return antecedentesMedRepository.findAll();
    }

    public Antecedentes_medicos obtenerAntecedentesPorId(int id_antecedentes){
        Antecedentes_medicos antecedentes_medicos = antecedentesMedRepository.findById(id_antecedentes).orElse(null);
        if (antecedentes_medicos == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "antecedentes no encontrada");
        }
        return antecedentes_medicos;

    }

    public Antecedentes_medicos agregarAntecedente(Agregar_antecedentes_med nuevo){
        Hoja_de_vida hoja = hojaRepository.findById(nuevo.getId_hoja()).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Hoja de vida no encontrada"));

        Antecedentes_medicos antecedente =new Antecedentes_medicos();
        antecedente.setHospital_nacimiento(nuevo.getHospital_nacimiento());
        antecedente.setEnfermedades(nuevo.getEnfermedades());
        antecedente.setLesiones(nuevo.getLesiones());
        antecedente.setMedicamentos(nuevo.getMedicamentos());
        antecedente.setFecha_enfermedad(nuevo.getFecha_enfermedad());
        antecedente.setFecha_lesiones(nuevo.getFecha_lesiones());
        antecedente.setEstado_enfermedad(nuevo.getEstado_enfermedad());
        antecedente.setHoja_de_vida(hoja);
        return antecedentesMedRepository.save(antecedente);
    }

    public String eliminarAntecedente(int id_antecedente){
        if (antecedentesMedRepository.existsById(id_antecedente)) { 
            antecedentesMedRepository.deleteById(id_antecedente);   
            return "antecedente Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada.");
        }
    }

    public Antecedentes_medicos actualizAntecedente(Actualizar_antecedentes_med actualizar_antecedentes_med){
        Antecedentes_medicos antecedentes_medicos = antecedentesMedRepository.findById(actualizar_antecedentes_med.getId_antecedente_med()).orElse(null);
        if(antecedentes_medicos == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"antecedente no encontrada");
        }else{
        antecedentes_medicos.setHospital_nacimiento(actualizar_antecedentes_med.getHospital_nacimiento());
        antecedentes_medicos.setEnfermedades(actualizar_antecedentes_med.getEnfermedades());
        antecedentes_medicos.setLesiones(actualizar_antecedentes_med.getLesiones());
        antecedentes_medicos.setMedicamentos(actualizar_antecedentes_med.getMedicamentos());
        antecedentes_medicos.setFecha_enfermedad(actualizar_antecedentes_med.getFecha_enfermedad());
        antecedentes_medicos.setFecha_lesiones(actualizar_antecedentes_med.getFecha_lesiones());
        antecedentes_medicos.setEstado_enfermedad(actualizar_antecedentes_med.getEstado_enfermedad());
        return antecedentesMedRepository.save(antecedentes_medicos);
        }
    }
}
