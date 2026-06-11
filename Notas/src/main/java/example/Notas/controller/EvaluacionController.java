package example.Notas.controller;

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

import example.Notas.model.entities.Evaluacion;
import example.Notas.model.request.ActualizarEvaluacion;
import example.Notas.model.request.AgregarEvaluacion;
import example.Notas.service.EvaluacionService;

@RestController
@RequestMapping("evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;


    @GetMapping("")
    public List<Evaluacion> obtenerTodasLasEvaluaciones(){
        return evaluacionService.obtenerTodasLasEvaluaciones();
    }

    @GetMapping("/{id_evaluacion}")
    public Evaluacion obtenerEvaluacionPorId(@PathVariable int id_evaluacion){
        return evaluacionService.obtenerEvaluacionPorId(id_evaluacion);
    }

    @PostMapping("")
    public Evaluacion agregarEvaluacion(@RequestBody AgregarEvaluacion nuevaEvaluacion){
        return evaluacionService.agregarEvaluacion(nuevaEvaluacion);
    }

    @PutMapping("{id_evaluacion}")
    public Evaluacion actualizarEvaluacion(@PathVariable int id_evaluacion, @RequestBody ActualizarEvaluacion nuevaEvaluacion){
        nuevaEvaluacion.setId_evaluacion(id_evaluacion);
        return evaluacionService.actualizarEvaluacion(nuevaEvaluacion);
    }
    
    
    @DeleteMapping("/{id_evaluacion}")
    public String eliminarEvaluacion(@PathVariable int id_evaluacion){
        return evaluacionService.eliminarEvaluacion(id_evaluacion);
    }


}
