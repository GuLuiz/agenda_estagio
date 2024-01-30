package br.com.agenda.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.agenda.entities.FuncionarioMenuEntity;

@Repository
public interface FuncionarioMenuRepository extends JpaRepository<FuncionarioMenuEntity,Integer>{
    
}
