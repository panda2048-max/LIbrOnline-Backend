package com.example.Usuarios.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Usuarios.models.entities.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer>{
    
}
