package com.example.Usuarios.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Usuarios.models.entities.Email;
import com.example.Usuarios.models.entities.Usuarios;
import com.example.Usuarios.models.request.ActualizarEmail;
import com.example.Usuarios.models.request.AgregarEmail;
import com.example.Usuarios.repositories.EmailRepository;
import com.example.Usuarios.repositories.UsuarioRepository;


@Service
public class EmailServices {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // OBTENER TODOS
    public List<Email> obtenerTodosLosEmail() {
        return emailRepository.findAll();
    }

    // OBTENER POR ID
    public Email obtenerEmailPorId(int id_email) {

        Email email = emailRepository.findById(id_email).orElse(null);

        if (email == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"email no encontrado");
        }

        return email;
    }

    // AGREGAR
    public Email agregarEmail(AgregarEmail nuevoEmail) {

        Usuarios usuario = usuarioRepository.findById(nuevoEmail.getId_usuario()).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "usuario no encontrado")
            );

        Email emailNuevo = new Email();
        emailNuevo.setEmail(nuevoEmail.getEmail());
        emailNuevo.setUsuarios(usuario);

        return emailRepository.save(emailNuevo);
    }

    // ELIMINAR
    public String eliminarEmail(int id_email) {

        if (emailRepository.existsById(id_email)) {
            emailRepository.deleteById(id_email);
            return "email eliminado correctamente.";

        } else {

            throw new ResponseStatusException( HttpStatus.NOT_FOUND, "email no encontrado");
        }
    }

    // ACTUALIZAR
    public Email actualizarEmail(ActualizarEmail actualizarEmail) {

        Email email = emailRepository
                .findById(actualizarEmail.getId_email())
                .orElse(null);

        if (email == null) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "email no encontrado"
            );
        }

        email.setEmail(actualizarEmail.getEmail());

        return emailRepository.save(email);
    }
}
