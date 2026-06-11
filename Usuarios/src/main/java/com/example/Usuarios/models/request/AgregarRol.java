package com.example.Usuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AgregarRol {
    
    @NotNull
    private Integer id_usuario;

    @NotBlank 
    private String tipo_rol;
}
