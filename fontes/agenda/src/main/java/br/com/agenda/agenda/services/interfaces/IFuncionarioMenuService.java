package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.FuncionarioMenuEntity;

public interface IFuncionarioMenuService {

    List<FuncionarioMenuEntity> findAll();

    FuncionarioMenuEntity add(FuncionarioMenuEntity menu);

    FuncionarioMenuEntity findById(Integer id);

    void delete(Integer id);

    FuncionarioMenuEntity updateFuncionarioMenu(FuncionarioMenuEntity funcMenu);

}