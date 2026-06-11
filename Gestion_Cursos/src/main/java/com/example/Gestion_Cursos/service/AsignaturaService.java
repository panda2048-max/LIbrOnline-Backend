package com.example.Gestion_Cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Cursos.models.entities.Asignatura;
import com.example.Gestion_Cursos.models.request.ActualizarAsignatura;
import com.example.Gestion_Cursos.models.request.AgregarAsignatura;
import com.example.Gestion_Cursos.repository.AsignaturaRepository;

@Service
public class AsignaturaService {
    
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public List <Asignatura> obtenerTodasLasAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Asignatura obtenerAsignaturaPorId(int id_asignatura){
        Asignatura asignatura = asignaturaRepository.findById(id_asignatura).orElse(null);
        if (asignatura == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada con esa id");
        }
        return asignatura;
    }

    public Asignatura agregarAsignatura(AgregarAsignatura nueva){
        Asignatura asignaturaNueva = new Asignatura();
        asignaturaNueva.setNombre_asignatura(nueva.getNombre_asignatura());
        return asignaturaRepository.save(asignaturaNueva);
    }

    public String eliminarAsignatura(Integer id_asignatura) {
        if (asignaturaRepository.existsById(id_asignatura)) {
            asignaturaRepository.deleteById(id_asignatura);
            return "Asignatura eliminada correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada con esa id");
        }
    }

    public Asignatura actualizarAsignatura(ActualizarAsignatura nuevaAsignatura) {
        Asignatura asignatura = asignaturaRepository.findById(nuevaAsignatura.getId_asignatura()).orElse(null);
        if (asignatura == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asignatura no encontrada con esa id");
        }
        asignatura.setNombre_asignatura(nuevaAsignatura.getNombre_asignatura());
        return asignaturaRepository.save(asignatura);
    }
}
