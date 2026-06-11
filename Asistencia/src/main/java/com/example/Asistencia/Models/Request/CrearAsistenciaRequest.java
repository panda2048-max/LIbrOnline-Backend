package com.example.Asistencia.Models.Request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CrearAsistenciaRequest {

    @NotBlank
    private String estudiante;

    @NotBlank
    private LocalDate fecha;

    @NotBlank   
    private String estado;

    @NotBlank
    private int id_usuarios;

}
