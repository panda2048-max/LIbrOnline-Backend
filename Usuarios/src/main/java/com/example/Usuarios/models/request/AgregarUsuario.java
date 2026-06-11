package com.example.Usuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AgregarUsuario {
    
    @NotBlank
    private String run_usuario;
    
    @NotBlank
    private String primer_nombre;

    @NotBlank
    private String segundo_nombre;

    @NotBlank
    private String ap_paterno;

    @NotBlank
    private String ap_materno;

    @NotBlank
    private String telefono;
}

