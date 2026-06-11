package com.example.direcciones.Controller;

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

import com.example.direcciones.models.entities.Ciudad;
import com.example.direcciones.models.request.ActualizarCiudad;
import com.example.direcciones.models.request.AgregarCiudad;
import com.example.direcciones.services.CiudadServices;


@RequestMapping("ciudad")
@RestController
public class CiudadController {
    
    @Autowired
    private CiudadServices ciudadServices;

    @GetMapping("")
    public List<Ciudad> obtenerTodasLasCiudades() {
        return ciudadServices.obtenerTodasLasCiudades();
    }
    
    @GetMapping("/{id_ciudad}")
    public Ciudad obtenerCiudadPorId(@PathVariable int id_ciudad){
        return ciudadServices.obtenerCiudadPorId(id_ciudad);
    }

    @PostMapping("")
    public Ciudad agregarCiudad(@RequestBody AgregarCiudad nuevaCiudad){ 
        return ciudadServices.agregarCiudad(nuevaCiudad);
    }

    @PutMapping("")
    public Ciudad actualizaCiudad(@RequestBody ActualizarCiudad actualizar) {       
        return ciudadServices.actualizarCiudad(actualizar);
    }
    
    @DeleteMapping("/{id_ciudad}")
    public String eliminarCiudad(@PathVariable int id_ciudad){
        return ciudadServices.eliminarCiudad(id_ciudad);
    }
}
