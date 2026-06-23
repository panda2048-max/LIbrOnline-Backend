package com.example.Usuarios.models.request;

import lombok.Data;

@Data
public class LoginRequest {

    private String runUsuario;
    
    private String password;
}
