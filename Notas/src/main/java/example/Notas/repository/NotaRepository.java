package example.Notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Notas.model.entities.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {
    
}
