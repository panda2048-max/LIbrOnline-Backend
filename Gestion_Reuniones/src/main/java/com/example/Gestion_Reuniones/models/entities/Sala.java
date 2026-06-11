package com.example.Gestion_Reuniones.models.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "salas")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id_sala;

    @Column(nullable = false)
    private String piso;

    @OneToMany(mappedBy = "sala")
    @JsonBackReference
    private List<Reunion> reuniones;

}
