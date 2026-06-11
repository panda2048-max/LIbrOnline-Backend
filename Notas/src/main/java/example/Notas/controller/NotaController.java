package example.Notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Notas.model.entities.Nota;
import example.Notas.model.request.ActualizarNota;
import example.Notas.model.request.AgregarNota;
import example.Notas.service.NotaService;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("nota")
@RestController
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @GetMapping("")
    public List<Nota> obtenerTodasLasNotas(){
        return notaService.obtenerTodasLasNotas();
    }

    @GetMapping("/{id_nota}")
    public Nota obtenerNotaPorId(@PathVariable int id_nota){
        return notaService.obtenerNotaPorId(id_nota);
    }

    @PostMapping("")
    public Nota agregarNota(@RequestBody AgregarNota nueva){
        return notaService.agregarNota(nueva);
    }

    // Queda simplemente apuntando a la ruta principal o "/actualizar"
    @PutMapping("") 
    public Nota actualizarNota(@RequestBody ActualizarNota nueva){
        return notaService.actualizarNota(nueva);
    }
    
    
    @DeleteMapping("/{id_nota}")
    public String eliminarNota(@PathVariable int id_nota){
        return notaService.eliminarNota(id_nota);
    }

}
