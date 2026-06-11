package com.example.Mensajeria.Controller;

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

import com.example.Mensajeria.Services.MensajeriaService;
import com.example.Mensajeria.Models.Entities.Mensajeria;
import com.example.Mensajeria.Models.Request.AgregarRequest;


@RestController
@RequestMapping("/mensajeria")
public class MensajeriaController {

    @Autowired
    private MensajeriaService mensajeriaService;

    @GetMapping("/{idMensaje}")
    public Mensajeria obtenerMensajePorId(@PathVariable int idMensaje) {
        return mensajeriaService.obtenerPorId(idMensaje);
    }
    
    @GetMapping("")
    public List<Mensajeria> listarMensajes() {
        return mensajeriaService.obtenerTodos();
    }

    @PostMapping("")
    public Mensajeria agregarmensaje (@RequestBody AgregarRequest Agregar){
        return mensajeriaService.agregarMensajeria(Agregar);
    }
    
    @DeleteMapping("/{idMensaje}")
    public String eliminarMensaje(@PathVariable int idMensaje) {
        return mensajeriaService.eliminarMensajeria(idMensaje);
    }
}