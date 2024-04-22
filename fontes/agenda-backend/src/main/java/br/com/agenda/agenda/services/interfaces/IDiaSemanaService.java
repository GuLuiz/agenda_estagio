package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.DiaSemanaEntity;

public interface IDiaSemanaService {

    List<DiaSemanaEntity> findAll();

    DiaSemanaEntity add(DiaSemanaEntity dia);

    DiaSemanaEntity findById(Integer id);

    void delete(Integer id);

    DiaSemanaEntity updateUsuario(DiaSemanaEntity dia);

}