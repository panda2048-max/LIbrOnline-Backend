package com.example.Anotaciones.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.Anotaciones.Models.Entities.Anotaciones;
import com.example.Anotaciones.Models.Request.AgregarAnotaciones;
import com.example.Anotaciones.Models.dto.UsuarioDto;
import com.example.Anotaciones.Repository.AnotacionesRepository;

@Service
public class AnotacionesService {

   @Autowired
    private AnotacionesRepository anotacionesRepository;

    @Autowired
    private WebClient usuarioWebClient;

    public List<Anotaciones> obtenerTodas() {
        return anotacionesRepository.findAll();
    }

    public Anotaciones obtenerPorId(Integer id) {
        return anotacionesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Anotación no encontrada"));
    }

    public Anotaciones agregarAnotacion(AgregarAnotaciones nuevoAnotacion){
        UsuarioDto usuarioDto =  null;
        try{
            usuarioDto = usuarioWebClient.get()
                .uri("/usuario/{id_usuario}", nuevoAnotacion.getId_usuarios())
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ENDPOINT ---> usuario no encontrada");
        }   
        if(usuarioDto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario no encontrada");
        }
        Anotaciones anotaciones = new Anotaciones();
        anotaciones.setTipo(nuevoAnotacion.getTipo());
        anotaciones.setDescripcion(nuevoAnotacion.getDescripcion());
        anotaciones.setFechaCreacion(LocalDate.now());
        anotaciones.setId_usuarios(nuevoAnotacion.getId_usuarios());
        return anotacionesRepository.save(anotaciones);
    }
    

    public String eliminar(Integer id) {

        if (anotacionesRepository.existsById(id)) {
            anotacionesRepository.deleteById(id);
            return "Anotación eliminada correctamente";
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Anotación no encontrada");
    }

    
}
