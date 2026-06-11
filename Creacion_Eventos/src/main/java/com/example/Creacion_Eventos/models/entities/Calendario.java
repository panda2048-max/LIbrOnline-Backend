package com.example.Creacion_Eventos.models.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "calendario")
public class Calendario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_calendario;

    private Date fecha_inicio;

    private Date fecha_fin;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

}
