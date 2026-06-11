package com.example.Gestion_Reuniones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion_Reuniones.models.entities.Sala;
import com.example.Gestion_Reuniones.models.request.ActualizarSala;
import com.example.Gestion_Reuniones.models.request.AgregarSala;
import com.example.Gestion_Reuniones.service.SalaService;

@RestController
@RequestMapping("sala")
public class SalaController {
    
    @Autowired
    private SalaService salaService;


    @GetMapping("")
    public List<Sala> obtenerTodasLasSalas(){
        return salaService.obtenerTodasLasSalas();
    }


    @GetMapping("/{id_sala}")
    public Sala obtenerSalaPorId(@PathVariable int id_sala){
        return salaService.obtenerSalaPorId(id_sala);
    }

    @PostMapping("")
    public Sala agregarSala(@RequestBody AgregarSala nueva){
        return salaService.agregarSala(nueva);
    }

    @PutMapping("")
    public Sala actualizarSala(@RequestBody ActualizarSala nuevaSala){
        return salaService.actualizarSala(nuevaSala);
    }

    @DeleteMapping("/{id_sala}")
    public String eliminarSala(@PathVariable int id_sala){
        return salaService.eliminarSala(id_sala);
    }
}
