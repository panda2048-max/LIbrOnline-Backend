package com.example.Asistencia.Models.Request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ActualizarAsistenciaRequest {

    @NotBlank
    private int id;

    @NotBlank
    private String estudiante;

    @NotBlank
    private LocalDate fecha;

    @NotBlank
    private String estado;
   
}
