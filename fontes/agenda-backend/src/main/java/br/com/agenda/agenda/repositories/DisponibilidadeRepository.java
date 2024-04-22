package br.com.agenda.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.agenda.entities.DisponibilidadeEntity;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadeEntity, Integer>{
    
}
