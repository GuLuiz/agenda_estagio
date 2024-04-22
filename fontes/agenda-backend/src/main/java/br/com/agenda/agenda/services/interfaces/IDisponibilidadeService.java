package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.DisponibilidadeEntity;

public interface IDisponibilidadeService {

    List<DisponibilidadeEntity> findAll();

    DisponibilidadeEntity add(DisponibilidadeEntity disp);

    DisponibilidadeEntity findById(Integer id);

    void delete(Integer id);

    DisponibilidadeEntity updateDisponibilidade(DisponibilidadeEntity disp);

}