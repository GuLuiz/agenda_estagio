package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.FuncionarioEntity;

public interface IFuncionarioService {

    List<FuncionarioEntity> findAll();

    FuncionarioEntity add(FuncionarioEntity funcionario);

    FuncionarioEntity findById(Integer id);

    void delete(Integer id);

    FuncionarioEntity updateFuncionario(FuncionarioEntity funcionario);

}