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

import com.example.direcciones.models.entities.Pais;
import com.example.direcciones.models.request.ActualizarPais;
import com.example.direcciones.models.request.AgregarPais;
import com.example.direcciones.services.PaisServices;

@RequestMapping("pais")
@RestController
public class PaisController {
    
    @Autowired
    private PaisServices paisServices;

    @GetMapping("")
    public List<Pais> obtenerTodosLosPaises() {
        return paisServices.obtenerTodosLosPaises();
    }
    
    @GetMapping("/{id_pais}")
    public Pais obtenerPaisPorId(@PathVariable int id_pais){
        return paisServices.obtenerPaisPorId(id_pais);
    }

    @PostMapping("")
    public Pais agregarPais(@RequestBody AgregarPais nuevaPais){ 
        return paisServices.agregarPais(nuevaPais);
    }

    @PutMapping("")
    public Pais actualizaPais(@RequestBody ActualizarPais actualizar) {       
        return paisServices.actualizarPais(actualizar);
    }
    
    @DeleteMapping("/{id_pais}")
    public String eliminarPais(@PathVariable int id_pais){
        return paisServices.eliminarPais(id_pais);
    }
}
