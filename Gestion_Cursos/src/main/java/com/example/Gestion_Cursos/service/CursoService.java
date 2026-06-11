package com.example.Gestion_Cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Cursos.models.dto.UsuarioDto;
import com.example.Gestion_Cursos.models.entities.Asignatura;
import com.example.Gestion_Cursos.models.entities.Curso;
import com.example.Gestion_Cursos.models.entities.Docente;
import com.example.Gestion_Cursos.models.request.ActualizarCurso;
import com.example.Gestion_Cursos.models.request.AgregarCurso;
import com.example.Gestion_Cursos.repository.AsignaturaRepository;
import com.example.Gestion_Cursos.repository.CursoRepository;
import com.example.Gestion_Cursos.repository.DocenteRepository;

@Service
public class CursoService {
    

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private WebClient usuarioWebClient;



    public List <Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCursoPorId(int id_curso) {
        Curso curso = cursoRepository.findById(id_curso).orElse(null);
        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con esa id");
        }
        return curso;
    }

    public Curso agregarCurso(AgregarCurso nuevo){
        UsuarioDto usuarioDto =  null;
        try{
            usuarioDto = usuarioWebClient.get()
                .uri("/usuario/{id_usuario}", nuevo.getId_usuarios())
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ENDPOINT ---> usuario no encontrada");
        }   
        if(usuarioDto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario no encontrada");
        }

        Docente docente = docenteRepository.findById(nuevo.getId_docente()).orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Docente no encontrado"));
        List<Asignatura> asignaturas = asignaturaRepository.findAllById(nuevo.getId_asignaturas());

        Curso cursoNuevo = new Curso();
        cursoNuevo.setLetra(nuevo.getLetra());
        cursoNuevo.setNivel_curso(nuevo.getNivel_curso());
        cursoNuevo.setId_sala(nuevo.getId_sala());
        cursoNuevo.setId_usuarios(nuevo.getId_usuarios());
        cursoNuevo.setDocente(docente);
        cursoNuevo.setAsignaturas(asignaturas);
        return cursoRepository.save(cursoNuevo);
    }

    public String eliminarCurso(int id_curso) {
        if (cursoRepository.existsById(id_curso)) {
            cursoRepository.deleteById(id_curso);
            return "Curso eliminado correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con esa id");
        }
    }

    public Curso actualizaCurso(ActualizarCurso nuevoCurso) {
        Curso curso = cursoRepository.findById(nuevoCurso.getId_curso()).orElse(null);
        if (curso == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no encontrado con esa id");
        }
        curso.setLetra(nuevoCurso.getLetra());
        curso.setNivel_curso(nuevoCurso.getNivel_curso());
        curso.setId_sala(nuevoCurso.getId_sala());

        Docente docente = docenteRepository.findById(nuevoCurso.getId_docente()).orElseThrow(() -> 
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Docente no encontrado"));
        curso.setDocente(docente);
        return cursoRepository.save(curso); 

    }
}
