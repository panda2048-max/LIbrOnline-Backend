package example.Notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import example.Notas.model.entities.Evaluacion;
import example.Notas.model.entities.Nota;
import example.Notas.model.request.ActualizarNota;
import example.Notas.model.request.AgregarNota;
import example.Notas.repository.NotaRepository;

@Service
public class NotaService {
    
    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private EvaluacionService evaluacionService;

    public List<Nota> obtenerTodasLasNotas(){
        return notaRepository.findAll();
    }

    public Nota obtenerNotaPorId(int id_nota){
        Nota nota = notaRepository.findById(id_nota).orElse(null);
        if (nota == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nota no encontrada con esa id");
        }
        return nota;
    }

    public Nota agregarNota(AgregarNota nueva){
        Evaluacion evaluacion = evaluacionService.obtenerEvaluacionPorId(nueva.getId_evaluacion());
        Nota notaNueva = new Nota();
        double calificacion = Double.parseDouble(nueva.getCalificacion());
        
        // Pequeña validación opcional
        if(calificacion < 1.0 || calificacion > 7.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La nota debe ser entre 1.0 y 7.0");
        }

        notaNueva.setCalificacion(calificacion);
        notaNueva.setEvaluacion(evaluacion);
        notaNueva.setRut_usuario(nueva.getRut_usuario());
        
        return notaRepository.save(notaNueva);
    }

    public String eliminarNota(int id_nota){
        if (notaRepository.existsById(id_nota)) {
            notaRepository.deleteById(id_nota);
            return "Nota eliminada correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nota no encontrada con esa id ");
        }
    }

    public Nota actualizarNota(ActualizarNota nuevaNota){
        Nota nota = notaRepository.findById(nuevaNota.getId_nota()).orElse(null);
        if (nota == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nota no encontrada con esa id");
        } else {
            double calificacion = Double.parseDouble(nuevaNota.getCalificacion());
            if(calificacion < 1.0 || calificacion > 7.0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La nota debe ser entre 1.0 y 7.0");
            }
            nota.setCalificacion(calificacion);
            // Si la actualización permite cambiar promedio, lo agregarías aquí.
            
            return notaRepository.save(nota);
        }
    }
}