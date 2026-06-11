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

import com.example.Gestion_Reuniones.models.entities.Reunion;
import com.example.Gestion_Reuniones.models.request.ActualizarReunion;
import com.example.Gestion_Reuniones.models.request.AgregarReunion;
import com.example.Gestion_Reuniones.service.ReunionService;

@RestController
@RequestMapping("reunion")
public class ReunionController {
    
    @Autowired
    private ReunionService reunionService;

    @GetMapping("")
    public List<Reunion> obtenerTodasLasReuniones(){
        return reunionService.obtenerTodasLasReuniones();
    }

    @GetMapping("/{id_reunion}")
    public Reunion obtenerReunionPorId(@PathVariable int id_reunion){
        return reunionService.obtenerReunionPorId(id_reunion);
    }

    @PostMapping("")
    public Reunion agregarReunion(@RequestBody AgregarReunion nueva){
        return reunionService.agregarReunion(nueva);
    }

    @PutMapping("")
    public Reunion actualizarReunion(@RequestBody ActualizarReunion nuevaReunion){
        return reunionService.actualizarReunion(nuevaReunion);
    }

    @DeleteMapping("/{id_reunion}")
    public String eliminarReunion(@PathVariable int id_reunion){
        return reunionService.eliminarReunion(id_reunion);
    }
}
