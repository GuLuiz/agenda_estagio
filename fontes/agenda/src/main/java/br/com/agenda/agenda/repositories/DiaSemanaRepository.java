package br.com.agenda.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.agenda.entities.DiaSemanaEntity;

public interface DiaSemanaRepository extends JpaRepository<DiaSemanaEntity, Integer>{
    
}
