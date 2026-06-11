package com.example.matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.entities.Hoja_de_vida;
import com.example.matriculas.models.entities.Matriculas;
import com.example.matriculas.models.request.Actualizar_matricula;
import com.example.matriculas.models.request.Agregar_matricula;
import com.example.matriculas.repositories.HojaVidaRepository;
import com.example.matriculas.repositories.MatriculasRepository;

@Service
public class MatriculaServices {
    
    @Autowired
    private MatriculasRepository matriculasRepository;

    @Autowired
    private HojaVidaRepository hojaRepository;

    public List<Matriculas> obtenerTodasLasMatriculas(){
        return matriculasRepository.findAll();
    }

    public Matriculas obtenerMatriculasPorId(int id_matriculas){
        Matriculas matriculas = matriculasRepository.findById(id_matriculas).orElse(null);
        if (matriculas == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "matricula no encontrada");
        }
        return matriculas;

    }

    public Matriculas agregarMatriculas(Agregar_matricula nuevaMatricula){
        Hoja_de_vida hoja = hojaRepository.findById(nuevaMatricula.getId_hoja()).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Hoja de vida no encontrada"));

        Matriculas matricula = new Matriculas();
        matricula.setFecha_matricula(nuevaMatricula.getFecha_matricula());
        matricula.setEstado_matricula(nuevaMatricula.getEstado_matricula());
        matricula.setCoste_matricula(nuevaMatricula.getCoste_matricula());
        matricula.setIva(nuevaMatricula.getIva());
        matricula.setTotal_matriculas(nuevaMatricula.getTotal_matriculas());
        matricula.setHoja_de_vida(hoja);
        return matriculasRepository.save(matricula);
    }

    public String eliminarMatriculas(int id_matricula){
        if (matriculasRepository.existsById(id_matricula)) { 
            matriculasRepository.deleteById(id_matricula);   
            return "matricula Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Matricula no encontrada.");
        }
    }

    public Matriculas actualizMatriculas(Actualizar_matricula actualizar_matricula){
        Matriculas matriculas = matriculasRepository.findById(actualizar_matricula.getId_matriculas()).orElse(null);
        if(matriculas == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"matricula no encontrada");
        }else{
        matriculas.setFecha_matricula(actualizar_matricula.getFecha_matricula());
        matriculas.setEstado_matricula(actualizar_matricula.getEstado_matricula());
        matriculas.setCoste_matricula(actualizar_matricula.getCoste_matricula());
        matriculas.setIva(actualizar_matricula.getIva());
        matriculas.setTotal_matriculas(actualizar_matricula.getTotal_matriculas());
        return matriculasRepository.save(matriculas);
        }
    }

}


