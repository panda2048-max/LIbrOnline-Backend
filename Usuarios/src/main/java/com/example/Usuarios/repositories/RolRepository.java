package com.example.Usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Usuarios.models.entities.Rol;

@Repository
public interface RolRepository  extends JpaRepository<Rol, Integer>{
 
}
