package com.example.Usuarios.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private int id_usuarios;
    private String runUsuario;
    private String primer_nombre;
}