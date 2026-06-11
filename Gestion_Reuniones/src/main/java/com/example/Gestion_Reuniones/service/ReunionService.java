package com.example.Gestion_Reuniones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Reuniones.models.dto.UsuarioDto;
import com.example.Gestion_Reuniones.models.entities.Reunion;
import com.example.Gestion_Reuniones.models.entities.Sala;
import com.example.Gestion_Reuniones.models.request.ActualizarReunion;
import com.example.Gestion_Reuniones.models.request.AgregarReunion;
import com.example.Gestion_Reuniones.repository.ReunionRepository;
import com.example.Gestion_Reuniones.repository.SalaRepository;

@Service
public class ReunionService {

    @Autowired
    private ReunionRepository reunionRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private WebClient usuarioWebClient;

    public List<Reunion> obtenerTodasLasReuniones() {
        return reunionRepository.findAll();
    }

    public Reunion obtenerReunionPorId(int id_reunion){
        Reunion reunion = reunionRepository.findById(id_reunion).orElse(null);
        if (reunion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reunión no encontrada con esa id: ");
        }
        return reunion;
    }


    public Reunion agregarReunion(AgregarReunion nueva){
        UsuarioDto usuarioDto =  null;
        try{
            usuarioDto = usuarioWebClient.get()
                .uri("/usuario/{id_usuario}", nueva.getId_usuarios())
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ENDPOINT ---> usuario no encontrada");
        }   
        if(usuarioDto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario no encontrada");
        }
        Sala sala = salaRepository.findById(nueva.getId_sala()).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND,"Sala no encontrada"));
            Reunion reunionNueva = new Reunion();
            reunionNueva.setFecha(nueva.getFecha());
            reunionNueva.setHora_inicio(nueva.getHora_inicio());
            reunionNueva.setHora_fin(nueva.getHora_fin());
            reunionNueva.setAsunto(nueva.getAsunto());
            reunionNueva.setEstado(nueva.getEstado());
            reunionNueva.setId_usuarios(nueva.getId_usuarios());
            reunionNueva.setSala(sala);
            return reunionRepository.save(reunionNueva);
    }
    

    public Reunion actualizarReunion(ActualizarReunion nuevaReunion){
        Reunion reunion = reunionRepository.findById(nuevaReunion.getId_reunion()).orElse(null);
        if (reunion == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reunión no encontrada con esa id: ");
        }
        reunion.setFecha(nuevaReunion.getFecha());
        reunion.setHora_inicio(nuevaReunion.getHora_inicio());
        reunion.setHora_fin(nuevaReunion.getHora_fin());
        reunion.setAsunto(nuevaReunion.getAsunto());
        reunion.setEstado(nuevaReunion.getEstado());
        return reunionRepository.save(reunion);
    }

    public String eliminarReunion(int id_reunion){
        if (reunionRepository.existsById(id_reunion)) {
            reunionRepository.deleteById(id_reunion);
            return "Reunión eliminada correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reunión no encontrada con esa id: ");
        }
    }

}
