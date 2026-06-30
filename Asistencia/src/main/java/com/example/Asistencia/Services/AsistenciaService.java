package com.example.Asistencia.Services;

import com.example.Asistencia.Models.Entities.Asistencia;
import com.example.Asistencia.Models.Request.ActualizarAsistenciaRequest;
import com.example.Asistencia.Models.Request.CrearAsistenciaRequest;
import com.example.Asistencia.Models.dto.UsuarioDto;
import com.example.Asistencia.Repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private WebClient usuarioWebClient;

    public List<Asistencia> obtenerTodas() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> obtenerPorId(int id) {
        return asistenciaRepository.findById(id);
    }

    public Asistencia agregarAsistencia(CrearAsistenciaRequest asistenciaRequest){
        UsuarioDto usuarioDto =  null;
        try{
            usuarioDto = usuarioWebClient.get()
                .uri("/usuario/{id_usuario}", asistenciaRequest.getId_usuarios())
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ENDPOINT ---> usuario no encontrada");
        }   
        if(usuarioDto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario no encontrada");
        }
        Asistencia asistencia = new Asistencia();
        asistencia.setEstudiante(asistenciaRequest.getEstudiante());
        asistencia.setFecha(asistenciaRequest.getFecha() != null ? asistenciaRequest.getFecha() : LocalDate.now());
        asistencia.setEstado(asistenciaRequest.getEstado());
        asistencia.setId_usuarios(asistenciaRequest.getId_usuarios());
        asistencia.setId_curso(asistenciaRequest.getId_curso());
        return asistenciaRepository.save(asistencia);
    }

    public Asistencia actualizarAsistencia(ActualizarAsistenciaRequest asistencia) {
        Asistencia asistenciaExistente = asistenciaRepository.findById(asistencia.getId()).orElse(null);
        if (asistenciaExistente == null) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"asistencia no encontrada");
        }else{
        asistenciaExistente.setEstudiante(asistencia.getEstudiante());
        asistenciaExistente.setFecha(asistencia.getFecha());
        asistenciaExistente.setEstado(asistencia.getEstado());
        asistenciaExistente.setId_curso(asistencia.getId_curso());
        return asistenciaRepository.save(asistenciaExistente);
        }
    }

    public void eliminarPorId(int id) {
        asistenciaRepository.deleteById(id);
    }
}
