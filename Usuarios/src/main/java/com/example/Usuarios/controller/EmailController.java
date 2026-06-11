package com.example.Usuarios.controller;

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

import com.example.Usuarios.models.entities.Email;
import com.example.Usuarios.models.request.ActualizarEmail;
import com.example.Usuarios.models.request.AgregarEmail;
import com.example.Usuarios.services.EmailServices;

@RequestMapping("email")
@RestController
public class EmailController {
    
    @Autowired
    private EmailServices emailServices;

    @GetMapping("")
    public List<Email> obtenerTodosLosEmails(){
        return emailServices.obtenerTodosLosEmail();
    }

    @GetMapping("/{id_email}")
    public Email obtenerEmialPorId(@PathVariable int id_email) {
        return emailServices.obtenerEmailPorId(id_email);
    }
    
    @PostMapping("")
    public Email agregarEmail(@RequestBody AgregarEmail nuevoEmail){
        return emailServices.agregarEmail(nuevoEmail);
    }
    
    @PutMapping("")
    public Email actualizarEmail(@RequestBody ActualizarEmail actualizar){ // JSON → DTO
        return emailServices.actualizarEmail(actualizar);
    }

    @DeleteMapping("/{id_email}")                   
    public String eliminarEmail(@PathVariable int id_email){ // Recibe ID de URL
        return emailServices.eliminarEmail(id_email); // Elimina de BD, devuelve mensaje
    }


}
