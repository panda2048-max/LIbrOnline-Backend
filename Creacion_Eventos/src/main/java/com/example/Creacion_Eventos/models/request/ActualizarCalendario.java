package com.example.Creacion_Eventos.models.request;

import java.sql.Date;

import lombok.Data;

@Data
public class ActualizarCalendario {
    
    private int id_calendario;

    private Date fecha_inicio;

    private Date fecha_fin;

    private Integer id_evento;

}
