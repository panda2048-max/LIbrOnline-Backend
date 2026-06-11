package com.example.Gestion_Cursos.models.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_curso;

    @Column(nullable = false)
    private String letra;

    @Column(nullable = false)
    private String nivel_curso;

    @Column(nullable = false)
    private int id_sala;

    @Column(nullable = false)
    private int id_usuarios;

    // relacion curso docente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_docente", nullable = false)
    private Docente docente;

    // relaion curso asignatura
    @ManyToMany
    @JoinTable(
        name = "curso_asignatura",
        joinColumns = @JoinColumn(name = "id_curso"),
        inverseJoinColumns = @JoinColumn(name = "id_asignatura")
    )
    private List<Asignatura> asignaturas;
}