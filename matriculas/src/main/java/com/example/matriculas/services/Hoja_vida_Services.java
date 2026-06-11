package com.example.matriculas.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.matriculas.models.dto.UsuarioDto;
import com.example.matriculas.models.entities.Hoja_de_vida;
import com.example.matriculas.models.request.Actualizar_hoja_vida;
import com.example.matriculas.models.request.Agregar_hoja_vida;
import com.example.matriculas.repositories.HojaVidaRepository;

@Service
public class Hoja_vida_Services {
    
    @Autowired
    private HojaVidaRepository hojaVidaRepository;

    @Autowired
    private WebClient usuarioWebClient;

    public List<Hoja_de_vida> obtenerTodasLasHojas(){
        return hojaVidaRepository.findAll();
    }

    public Hoja_de_vida obtenerHojasPorId(int id_hoja_vida){
        Hoja_de_vida hoja_de_vida = hojaVidaRepository.findById(id_hoja_vida).orElse(null);
        if (hoja_de_vida == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "hoja no encontrada");
        }
        return hoja_de_vida;

    }

    public Hoja_de_vida agregarHoja(Agregar_hoja_vida nuevoHoja){
        UsuarioDto usuarioDto =  null;
        try{
            usuarioDto = usuarioWebClient.get()
                .uri("/usuario/{id_usuario}", nuevoHoja.getId_usuarios())
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ENDPOINT ---> usuario no encontrada");
        }   
        if(usuarioDto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario no encontrada");
        }
        Hoja_de_vida HojaNuevo = new Hoja_de_vida();
        HojaNuevo.setFecha_creacion(LocalDate.now());
        HojaNuevo.setId_usuarios(nuevoHoja.getId_usuarios());
        return hojaVidaRepository.save(HojaNuevo);
        
    } 


    public String eliminarHoja(int id_hoja){
        if (hojaVidaRepository.existsById(id_hoja)) { 
            hojaVidaRepository.deleteById(id_hoja);   
            return "hoja Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"hoja no encontrada.");
        }
    }

    public Hoja_de_vida actualizHoja(Actualizar_hoja_vida actualizar_hoja_vida){
        Hoja_de_vida hoja_de_vida = hojaVidaRepository.findById(actualizar_hoja_vida.getId_hoja_vida()).orElse(null);
        if(hoja_de_vida == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"hoja no encontrada");
        }else{
        hoja_de_vida.setFecha_creacion(actualizar_hoja_vida.getFecha_cracion());
        return hojaVidaRepository.save(hoja_de_vida);
        }
    }
}
