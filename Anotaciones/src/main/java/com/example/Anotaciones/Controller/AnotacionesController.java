package com.example.Anotaciones.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.Anotaciones.Models.Entities.Anotaciones;
import com.example.Anotaciones.Models.Request.AgregarAnotaciones;
import com.example.Anotaciones.Services.AnotacionesService;




@RestController
@RequestMapping("/anotaciones")
@CrossOrigin("")
public class AnotacionesController {

    @Autowired
    private AnotacionesService anotacionesService;

    @GetMapping("")
    public List<Anotaciones> listar() {
        return anotacionesService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Anotaciones obtener(@PathVariable Integer id) {
        return anotacionesService.obtenerPorId(id);
    }

    @PostMapping("")
    public Anotaciones guardar(@RequestBody AgregarAnotaciones anotacion) {
        return anotacionesService.agregarAnotacion(anotacion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return anotacionesService.eliminar(id);
    }

}
