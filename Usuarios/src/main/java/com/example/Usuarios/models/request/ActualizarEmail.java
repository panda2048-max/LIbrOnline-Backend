package com.example.Usuarios.models.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ActualizarEmail {

    @NotNull
    private Integer id_email;

    @NotBlank
    private String email;
}
