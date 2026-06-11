package com.example.Mensajeria.Models.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data

public class AgregarRequest {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    @NotBlank(message = "El destinatario es obligatorio")
    private String destinatario;
    @NotBlank
    private int id_usuarios;
    
}
