package com.example.Gestion_Reuniones.models.entities;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "reunion")
public class Reunion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id_reunion;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Time hora_inicio;

    @Column(nullable = false)
    private Time hora_fin;

    @Column(nullable = false)
    private String asunto;

    @Column(nullable = false)
    private String estado;
    
    @Column(nullable = false)
    private int id_usuarios;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala sala;

    @JsonBackReference
    @OneToMany(mappedBy = "reunion")
    private List<Asistente> asistentes;
}
