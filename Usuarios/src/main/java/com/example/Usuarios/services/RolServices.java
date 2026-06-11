package com.example.Usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Usuarios.models.entities.Rol;
import com.example.Usuarios.models.entities.Usuarios;
import com.example.Usuarios.models.request.ActualizarRol;
import com.example.Usuarios.models.request.AgregarRol;
import com.example.Usuarios.repositories.RolRepository;
import com.example.Usuarios.repositories.UsuarioRepository;

@Service
public class RolServices {
    
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Rol> obtenerTodosLosRoles(){
        return rolRepository.findAll();
    }

    public Rol obtenerRolesPorId(int id_rol){
        Rol rol = rolRepository.findById(id_rol).orElse(null);
        if (rol == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"rol no encontrado");
        }
        return rol;
    }

    public Rol agregarRol(AgregarRol nuevoRol){
        Usuarios usuarios =usuarioRepository.findById(nuevoRol.getId_usuario()).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario no encontrado"));
        Rol rol = new Rol();
        rol.setTipo_rol(nuevoRol.getTipo_rol());
        rol.setUsuarios(usuarios);
        return rolRepository.save(rol);
    }

    public String eliminarRol(int id_rol){
        if(rolRepository.existsById(id_rol)){
            rolRepository.deleteById(id_rol);
            return "Rol eliminado correctamente.";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"rol no encontrado");
        }
    }

    public Rol actualizarRol(ActualizarRol actualizarRol){
        Rol rol = rolRepository.findById(actualizarRol.getId_rol()).orElse(null);
        if(rol == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"rol no encontrado");
        }else{

            rol.setTipo_rol(actualizarRol.getTipo_rol());
            return rolRepository.save(rol);
        }
    }
}
