package com.example.Mensajeria.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.Mensajeria.Models.Entities.Mensajeria;
import com.example.Mensajeria.Models.Request.AgregarRequest;
import com.example.Mensajeria.Models.dto.UsuarioDto;
import com.example.Mensajeria.Repositories.MensajeriaRepository;

import java.util.List;
@Service


public class MensajeriaService {
    @Autowired
    private MensajeriaRepository mensajeriaRepository;

    @Autowired
    private WebClient usuarioWebClient;


    public List<Mensajeria> obtenerTodos() {
        return mensajeriaRepository.findAll();
    }

    
    public Mensajeria obtenerPorId(int id) {
        Mensajeria mensajeria = mensajeriaRepository.findById(id).orElse(null);
        if (mensajeria == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensaje no encontrado ");
        }
        return mensajeria;
    }

    public Mensajeria agregarMensajeria(AgregarRequest request) {
        UsuarioDto usuarioDto =  null;
        try{
            usuarioDto = usuarioWebClient.get()
                .uri("/usuario/{id_usuario}", request.getId_usuarios())
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ENDPOINT ---> usuario no encontrada");
        }   
        if(usuarioDto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario no encontrada");
        }
        Mensajeria mensajeria = new Mensajeria();
        mensajeria.setTitulo(request.getTitulo());
        mensajeria.setDescripcion(request.getDescripcion());
        mensajeria.setDestinatario(request.getDestinatario());
        mensajeria.setFechaEnvio(java.time.LocalDateTime.now());
        mensajeria.setId_usuarios(request.getId_usuarios());
        return mensajeriaRepository.save(mensajeria);
    }

    public String eliminarMensajeria (int id) {
        if (mensajeriaRepository.existsById(id)){
            mensajeriaRepository.deleteById(id);
            return "Mensaje eliminado correctamente";

        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensaje no encontrado");
        }


    
    }
 
}
