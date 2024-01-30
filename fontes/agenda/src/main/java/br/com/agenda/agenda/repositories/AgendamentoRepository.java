package br.com.agenda.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.agenda.entities.AgendamentoEntity;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Integer>{
    
}
