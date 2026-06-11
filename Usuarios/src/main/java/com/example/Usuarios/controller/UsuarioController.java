package com.example.Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Usuarios.models.entities.Usuarios;
import com.example.Usuarios.models.request.ActualizarUsuario;
import com.example.Usuarios.models.request.AgregarUsuario;
import com.example.Usuarios.services.UsuariosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("usuario")
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("")
    public List<Usuarios> obtenerTodosLosUsuarios(){
        return usuariosService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/{id_usuario}")
    public Usuarios obtenerUsuarioPorId(@PathVariable int id_usuario) {
        return usuariosService.obtenerUsuariosPorId(id_usuario);
    }
    
    @PostMapping("")
    public Usuarios agregarUsuarios(@RequestBody AgregarUsuario nuevoUsuario){
        return usuariosService.agregarUsuarios(nuevoUsuario);
    }
    
    @PutMapping("")
    public Usuarios actualizarUsuarios(@RequestBody ActualizarUsuario actualizar){ // JSON → DTO
        return usuariosService.actualizarUsuarios(actualizar);
    }

    @DeleteMapping("/{id_usuario}")                    // {idMarca} de la URL
    public String eliminarUsuario(@PathVariable int id_usuario){ // Recibe ID de URL
        return usuariosService.eliminarUsuario(id_usuario); // Elimina de BD, devuelve mensaje
    }

}
