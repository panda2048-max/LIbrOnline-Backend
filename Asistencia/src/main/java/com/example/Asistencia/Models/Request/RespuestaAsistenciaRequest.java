package com.example.Asistencia.Models.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data

public class RespuestaAsistenciaRequest {

    @NotBlank
    private int id;

    @NotBlank
    private String estudiante;

    @NotBlank
    private LocalDate fecha;

    @NotBlank
    private String estado;

    
}
