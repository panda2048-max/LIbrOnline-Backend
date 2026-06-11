package com.example.direcciones.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.direcciones.models.entities.Direccion;
import com.example.direcciones.models.request.ActualizarDireccion;
import com.example.direcciones.models.request.AgregarDireccion;
import com.example.direcciones.services.DireccionServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("direccion")
@RestController
public class DireccionController {
    
    @Autowired
    private DireccionServices direccionServices;

    @GetMapping("")
    public List<Direccion> obtenerTodasLasDirecciones() {
        return direccionServices.obtenerTodasLasDirecciones();
    }
    
    @GetMapping("/{id_direccion}")
    public Direccion obtenerDireccionPorId(@PathVariable int id_direccion){
        return direccionServices.obtenerDireccionPorId(id_direccion);
    }

    @PostMapping("")
    public Direccion agregarDireccion(@RequestBody AgregarDireccion nuevaDireccion){ 
        return direccionServices.agregarDireccion(nuevaDireccion);
    }

    @PutMapping("")
    public Direccion actualizaDireccion(@RequestBody ActualizarDireccion actualizar) {       
        return direccionServices.actualizardDireccion(actualizar);
    }
    
    @DeleteMapping("/{id_direccion}")
    public String eliminarDireccion(@PathVariable int id_direccion){
        return direccionServices.eliminarDireccion(id_direccion);
    }

}
