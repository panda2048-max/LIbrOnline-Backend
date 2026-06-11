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

import com.example.Gestion_Reuniones.models.entities.Asistente;
import com.example.Gestion_Reuniones.models.request.ActualizarAsistente;
import com.example.Gestion_Reuniones.models.request.AgregarAsistente;
import com.example.Gestion_Reuniones.service.AsistenteService;

@RestController
@RequestMapping("asistente")
public class AsistenteController {
    
    @Autowired
    private AsistenteService asistenteService;

    @GetMapping("")
    public List<Asistente> obtenerTodosLosAsistentes(){
        return asistenteService.obtenerTodosAsistentes();
    }

    @GetMapping("/{id_asistente}")
    public Asistente obtenerAsistentePorId(@PathVariable int id_asistente){
        return asistenteService.obtenerAsistentePorId(id_asistente);
    }


    @PostMapping("")
    public Asistente agregarAsistente(@RequestBody AgregarAsistente nuevoAsistente){
        return asistenteService.agregarAsistente(nuevoAsistente);
    }



    @PutMapping("")
    public Asistente actualizarAsistente(@RequestBody ActualizarAsistente nuevoAsistente){
        return asistenteService.actualizarAsistente(nuevoAsistente);
    }

    @DeleteMapping("/{id_asistente}")
    public String eliminarAsistente(@PathVariable int id_asistente){
        return asistenteService.eliminarAsistente(id_asistente);
    }
}
