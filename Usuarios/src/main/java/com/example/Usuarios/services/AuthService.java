package com.example.Usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuarios.models.entities.Usuarios;
import com.example.Usuarios.models.request.LoginRequest;
import com.example.Usuarios.models.response.LoginResponse;
import com.example.Usuarios.repositories.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public LoginResponse login(LoginRequest request) {

    System.out.println("RUN RECIBIDO: [" + request.getRunUsuario() + "]");
    System.out.println("PASSWORD RECIBIDO: [" + request.getPassword() + "]");

    if (request.getRunUsuario() == null || request.getRunUsuario().isBlank()) {
        throw new RuntimeException("runUsuario es obligatorio");
    }

    String run = request.getRunUsuario().trim();

    Usuarios usuario = usuarioRepository
            .findByRunUsuario(run)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

    if (!usuario.getPassword().equals(request.getPassword())) {
        throw new RuntimeException("Contraseña incorrecta");
    }

    return new LoginResponse(
            usuario.getId_usuarios(),
            usuario.getRunUsuario(),
            usuario.getPrimer_nombre()
    );
        }
}