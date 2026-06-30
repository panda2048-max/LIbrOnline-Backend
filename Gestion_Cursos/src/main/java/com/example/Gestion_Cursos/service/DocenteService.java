package com.example.Gestion_Cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Cursos.models.entities.Docente;
import com.example.Gestion_Cursos.models.request.ActualizarDocente;
import com.example.Gestion_Cursos.models.request.AgregarDocente;
import com.example.Gestion_Cursos.repository.DocenteRepository;

@Service
public class DocenteService {
    
    @Autowired
    private DocenteRepository docenteRepository;


    public List <Docente> obtenerTodosLosDocentes() {
        return docenteRepository.findAll();
    }

    public Docente obtenerDocentePorId(int id_docente){
        Docente docente = docenteRepository.findById(id_docente).orElse(null);
        if (docente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Docente no encontrado con esa id");
        }
        return docente;
    }

    public Docente agregarDocente(AgregarDocente nuevo) {
        Docente docenteNuevo = new Docente();
        docenteNuevo.setNombre(nuevo.getNombre_docente());
        docenteNuevo.setEspecialidad(nuevo.getEspecialidad());
        docenteNuevo.setId_usuario(nuevo.getId_usuario());
        return docenteRepository.save(docenteNuevo);
    }

    public String eliminarDocente(Integer id_docente) {
        if (docenteRepository.existsById(id_docente)) {
            docenteRepository.deleteById(id_docente);
            return "Docente eliminado correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Docente no encontrado con esa id");
        }
    }


    public Docente actualizaDocente(ActualizarDocente nuevoDocente) {

    Docente docente = docenteRepository
        .findById(nuevoDocente.getId_docente())
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Docente no encontrado"
        ));

    docente.setNombre(nuevoDocente.getNombre_docente());
    docente.setEspecialidad(nuevoDocente.getEspecialidad());

    return docenteRepository.save(docente);
}
    
}
