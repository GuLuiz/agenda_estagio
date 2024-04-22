package br.com.agenda.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.agenda.entities.ImagemEntity;

@Repository
public interface ImagemRepository extends JpaRepository<ImagemEntity, Integer>{
    
}
