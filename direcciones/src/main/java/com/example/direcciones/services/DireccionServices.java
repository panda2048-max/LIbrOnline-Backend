package com.example.direcciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.direcciones.models.dto.UsuarioDto;
import com.example.direcciones.models.entities.Comuna;
import com.example.direcciones.models.entities.Direccion;
import com.example.direcciones.models.request.ActualizarDireccion;
import com.example.direcciones.models.request.AgregarDireccion;
import com.example.direcciones.repositories.ComunaRepository;
import com.example.direcciones.repositories.DireccionRepository;


@Service
public class DireccionServices {
    
    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private ComunaRepository comunaRepository;

    @Autowired
    private WebClient usuarioWebClient;

    public List<Direccion> obtenerTodasLasDirecciones(){
        return direccionRepository.findAll();
    }

    public Direccion obtenerDireccionPorId(int id_direccion){
        Direccion direccion = direccionRepository.findById(id_direccion).orElse(null);
        if(direccion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"region no encontrada");
        }
        return direccion;
    }

    public Direccion agregarDireccion(AgregarDireccion nuevaDireccion){
    // buscar comuna
    Comuna comuna = comunaRepository.findById(nuevaDireccion.getId_comuna()).orElseThrow(() ->
        new ResponseStatusException(HttpStatus.NOT_FOUND,"Comuna no encontrada"));

        try {System.out.println("Buscando usuario: " + nuevaDireccion.getId_usuarios());

        // buscar usuario en microservicio
        UsuarioDto usuarioDto = usuarioWebClient.get()
            .uri("/usuario/{id_usuario}",
                nuevaDireccion.getId_usuarios())
            .retrieve()
            .bodyToMono(UsuarioDto.class)
            .block();

        System.out.println(usuarioDto);

        // validar usuario
        if(usuarioDto == null){

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Usuario no encontrado"
            );
        }
        // crear direccion
        Direccion direccionNueva = new Direccion();
        direccionNueva.setId_usuarios(nuevaDireccion.getId_usuarios());
        direccionNueva.setCalle(nuevaDireccion.getCalle());
        direccionNueva.setNumero(nuevaDireccion.getNumero());
        // conectar comuna
        direccionNueva.setComuna(comuna);
        return direccionRepository.save(direccionNueva);

    } catch(Exception e){

        e.printStackTrace();

        throw new RuntimeException(e);
    }
}

    public String eliminarDireccion(int id_direccion){
        if(direccionRepository.existsById(id_direccion)){
            direccionRepository.deleteById(id_direccion);
            return"direccion eliminada correctamente. ";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"direccion no encontrada");
        }
    }

    public Direccion actualizardDireccion(ActualizarDireccion actualizarDireccion){
        Direccion direccion= direccionRepository.findById(actualizarDireccion.getId_direccion()).orElse(null);
        if(direccion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "direccion no encontrada");
        }else{
            direccion.setCalle(actualizarDireccion.getCalle());
            direccion.setNumero(0);
            return direccionRepository.save(direccion);
        }
    }
}
