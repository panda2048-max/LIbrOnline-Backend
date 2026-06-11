package com.example.Gestion_Reuniones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Gestion_Reuniones.models.entities.Asistente;
import com.example.Gestion_Reuniones.models.entities.Reunion;
import com.example.Gestion_Reuniones.models.request.ActualizarAsistente;
import com.example.Gestion_Reuniones.models.request.AgregarAsistente;
import com.example.Gestion_Reuniones.repository.AsistenteRepository;
import com.example.Gestion_Reuniones.repository.ReunionRepository;

@Service
public class AsistenteService {

    @Autowired
    private AsistenteRepository asistenteRepository;

    @Autowired
    private ReunionRepository reunionRepository;

    public List<Asistente> obtenerTodosAsistentes(){
        return asistenteRepository.findAll();
    }
    

    public Asistente obtenerAsistentePorId(int id_asistente){
        Asistente asistente = asistenteRepository.findById(id_asistente).orElse(null);
        if (asistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asistente no encontrado con id: ");
        }
        return asistente;
    }

    public Asistente agregarAsistente(AgregarAsistente nuevo){
        Reunion reunion = reunionRepository.findById(nuevo.getId_reunion()).orElseThrow(() ->
         new ResponseStatusException(HttpStatus.NOT_FOUND,"Reunion no encontrada"));
         
        Asistente asistente = new Asistente();
        asistente.setPrimer_nombre(nuevo.getPrimer_nombre());
        asistente.setSegundo_nombre(nuevo.getSegundo_nombre());
        asistente.setPrimer_apellido(nuevo.getPrimer_apellido());
        asistente.setSegundo_apellido(nuevo.getSegundo_apellido());
        asistente.setReunion(reunion);
        return asistenteRepository.save(asistente);
    }

    public Asistente actualizarAsistente(ActualizarAsistente nuevoAsistente){
        Asistente asistente = asistenteRepository.findById(nuevoAsistente.getId_asistente()).orElse(null);
        if (asistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asistente no encontrado con id: ");
        }
        asistente.setPrimer_nombre(nuevoAsistente.getPrimer_nombre());
        asistente.setSegundo_nombre(nuevoAsistente.getSegundo_nombre());
        asistente.setPrimer_apellido(nuevoAsistente.getPrimer_apellido());
        asistente.setSegundo_apellido(nuevoAsistente.getSegundo_apellido());
        return asistenteRepository.save(asistente);
    }

    public String eliminarAsistente(int id_asistente){
        if (asistenteRepository.existsById(id_asistente)) {
            asistenteRepository.deleteById(id_asistente);
            return "Asistente eliminado correctamente";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asistente no encontrado con id: ");
        }
    }


}
