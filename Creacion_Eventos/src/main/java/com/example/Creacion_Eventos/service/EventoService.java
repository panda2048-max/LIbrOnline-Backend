package com.example.Creacion_Eventos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.Creacion_Eventos.models.dto.UsuarioDto;
import com.example.Creacion_Eventos.models.entities.Evento;
import com.example.Creacion_Eventos.models.request.ActualizarEvento;
import com.example.Creacion_Eventos.models.request.AgregarEvento;
import com.example.Creacion_Eventos.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private WebClient usuarioWebClient;
    

    public List<Evento> obtenerTodosLosEventos(){
        return eventoRepository.findAll();
    }

    public Evento obtenerEventoPorId(int id_evento){
        Evento evento = eventoRepository.findById(id_evento).orElse(null);
        if (evento == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado con esa id ");
        }
        return evento;
    }

    public Evento agregarEvento(AgregarEvento nuevo){
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
        Evento evento = new Evento();
        evento.setTitulo(nuevo.getTitulo());
        evento.setAsunto(nuevo.getAsunto());
        evento.setFecha_inicio(nuevo.getFecha_inicio());
        evento.setFecha_fin(nuevo.getFecha_fin());
        evento.setTipo_evento(nuevo.getTipo_evento());
        evento.setId_usuarios(nuevo.getId_usuarios());

        return eventoRepository.save(evento);
    }

    public Evento actualizarEvento(ActualizarEvento nuevoEvento){
        Evento evento = eventoRepository.findById(nuevoEvento.getId_evento()).orElse(null);
        if (evento == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado con esa id ");
        }
        evento.setTitulo(nuevoEvento.getTitulo());
        evento.setAsunto(nuevoEvento.getAsunto());
        evento.setFecha_inicio(nuevoEvento.getFecha_inicio());
        evento.setFecha_fin(nuevoEvento.getFecha_fin());
        evento.setTipo_evento(nuevoEvento.getTipo_evento());
        return eventoRepository.save(evento);
    }




    public String eliminarEvento(int id_evento){
        if (eventoRepository.existsById(id_evento)) {
            eventoRepository.deleteById(id_evento);
            return "Evento eliminado con éxito";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no encontrado con esa id ");
        }
    }

}
