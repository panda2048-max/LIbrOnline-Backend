package example.Notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import example.Notas.model.dto.UsuarioDto;
import example.Notas.model.entities.Evaluacion;
import example.Notas.model.request.ActualizarEvaluacion;
import example.Notas.model.request.AgregarEvaluacion;
import example.Notas.repository.EvaluacionRepository;

@Service
public class EvaluacionService {
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    @Autowired
    private WebClient usuarioWebClient;

    public List<Evaluacion> obtenerTodasLasEvaluaciones(){
        return evaluacionRepository.findAll();
    }

    public Evaluacion obtenerEvaluacionPorId(int id_evaluacion){
        Evaluacion evaluacion = evaluacionRepository.findById(id_evaluacion).orElse(null);
        if (evaluacion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluacion no encontrada con esa id");
        }
        return evaluacion;
    }

    public Evaluacion agregarEvaluacion(AgregarEvaluacion nuevaEvaluacion){
        try{

        System.out.println("Buscando usuario: " + nuevaEvaluacion.getId_usuarios());
        UsuarioDto usuarioDto = usuarioWebClient.get()
                .uri("/usuario/{id_usuario}", nuevaEvaluacion.getId_usuarios())
                .retrieve()
                .bodyToMono(UsuarioDto.class)
                .block();

        System.out.println(usuarioDto);
        if(usuarioDto == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "usuario no encontrada"
                );
            }
        
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setFecha_evaluacion(nuevaEvaluacion.getFecha_evaluacion());
        evaluacion.setAsignatura(nuevaEvaluacion.getAsignatura());
        evaluacion.setTipo_evaluacion(nuevaEvaluacion.getTipo_evaluacion());
        evaluacion.setId_usuarios(nuevaEvaluacion.getId_usuarios());
        evaluacion.setId_curso(nuevaEvaluacion.getId_curso());
        return evaluacionRepository.save(evaluacion);
        }catch(Exception e){

        e.printStackTrace();

        throw new RuntimeException(e);
        }
    }

    public Evaluacion actualizarEvaluacion(ActualizarEvaluacion nuevaEvaluacion){
        Evaluacion evaluacion = evaluacionRepository.findById(nuevaEvaluacion.getId_evaluacion()).orElse(null);
        if (evaluacion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluacion no encontrada con esa id");
        }else{
        evaluacion.setFecha_evaluacion(nuevaEvaluacion.getFecha_evaluacion());
        evaluacion.setAsignatura(nuevaEvaluacion.getAsignatura());
        evaluacion.setTipo_evaluacion(nuevaEvaluacion.getTipo_evaluacion());
        evaluacion.setId_curso(nuevaEvaluacion.getId_curso());
        return evaluacionRepository.save(evaluacion);
        }
    }

    public String eliminarEvaluacion(int id_evaluacion){
        if (evaluacionRepository.existsById(id_evaluacion)){
            evaluacionRepository.deleteById(id_evaluacion);
            return "Evaluacion eliminada correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluacion no encontrada con esa id");
        }
    }
}
