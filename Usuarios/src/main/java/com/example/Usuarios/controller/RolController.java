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

import com.example.Usuarios.models.entities.Rol;
import com.example.Usuarios.models.request.ActualizarRol;
import com.example.Usuarios.models.request.AgregarRol;
import com.example.Usuarios.services.RolServices;

@RequestMapping("rol")
@RestController
public class RolController {
    
    @Autowired
    private RolServices rolServices;

    @GetMapping("")
    public List<Rol> obtenerTodosLosRoles(){
        return rolServices.obtenerTodosLosRoles();
    }

    @GetMapping("/{id_rol}")
    public Rol obtenerRolesPorId(@PathVariable int id_rol) {
        return rolServices.obtenerRolesPorId(id_rol);
    }
    
    @PostMapping("")
    public Rol agregarRoles(@RequestBody AgregarRol nuevoRol){
        return rolServices.agregarRol(nuevoRol);
    }
    
    @PutMapping("")
    public Rol actualizarRol(@RequestBody ActualizarRol actualizar){ // JSON → DTO
        return rolServices.actualizarRol(actualizar);
    }

    @DeleteMapping("/{id_rol}")                   
    public String eliminarRol(@PathVariable int id_rol){ // Recibe ID de URL
        return rolServices.eliminarRol(id_rol); // Elimina de BD, devuelve mensaje
    }

}
