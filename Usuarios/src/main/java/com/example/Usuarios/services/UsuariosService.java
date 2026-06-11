package com.example.Usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Usuarios.models.entities.Usuarios;
import com.example.Usuarios.models.request.ActualizarUsuario;
import com.example.Usuarios.models.request.AgregarUsuario;
import com.example.Usuarios.repositories.UsuarioRepository;

@Service
public class UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuarios> obtenerTodosLosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuarios obtenerUsuariosPorId(int id_usuarios){
        Usuarios usuarios = usuarioRepository.findById(id_usuarios).orElse(null);
        if (usuarios == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario no encontrado");
        }
        return usuarios;
    }

    public Usuarios agregarUsuarios(AgregarUsuario nuevoUsuario){
        Usuarios usuarioNuevo = new Usuarios();
        usuarioNuevo.setRun_usuario(nuevoUsuario.getRun_usuario());
        usuarioNuevo.setPrimer_nombre(nuevoUsuario.getPrimer_nombre());
        usuarioNuevo.setSegundo_nombre(nuevoUsuario.getSegundo_nombre());
        usuarioNuevo.setAp_paterno(nuevoUsuario.getAp_paterno());
        usuarioNuevo.setAp_materno(nuevoUsuario.getAp_materno());
        usuarioNuevo.setTelefono(nuevoUsuario.getTelefono());
        return usuarioRepository.save(usuarioNuevo);

    }

    public String eliminarUsuario(int id_usuario){
        if (usuarioRepository.existsById(id_usuario)) { 
            usuarioRepository.deleteById(id_usuario);   
            return "Usuario Eliminada correctamente."; 
        }else{
            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrada.");
        }
    }

    public Usuarios actualizarUsuarios(ActualizarUsuario actUsuario){
            Usuarios Usuario = usuarioRepository.findById(actUsuario.getId_usuario()).orElse(null); // Busca
            if(Usuario == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrada.");
            }else{
            /* 
             * ACTUALIZA solo el nombre
             * save() detecta que ya existe → UPDATE SQL
             */
            Usuario.setRun_usuario(actUsuario.getRun_usuario());
            Usuario.setPrimer_nombre(actUsuario.getPrimer_nombre());
            Usuario.setSegundo_nombre(actUsuario.getSegundo_nombre());
            Usuario.setAp_paterno(actUsuario.getAp_paterno());
            Usuario.setAp_materno(actUsuario.getAp_materno());
            Usuario.setTelefono(actUsuario.getTelefono());
            return usuarioRepository.save(Usuario); // Actualiza en BD
        }
    }

}