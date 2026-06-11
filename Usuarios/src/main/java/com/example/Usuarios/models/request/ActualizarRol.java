package com.example.Usuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarRol {
    
    @NotNull
    private int id_rol;

    @NotBlank 
    private String tipo_rol;
}
