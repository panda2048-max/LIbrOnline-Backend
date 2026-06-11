package com.example.Usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Usuarios.models.entities.Usuarios;


@Repository
public interface UsuarioRepository  extends JpaRepository<Usuarios, Integer> {

    
}