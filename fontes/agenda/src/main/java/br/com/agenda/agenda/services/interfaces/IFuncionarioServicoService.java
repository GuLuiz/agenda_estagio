package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.FuncionarioServicoEntity;

public interface IFuncionarioServicoService {

    List<FuncionarioServicoEntity> findAll();

    FuncionarioServicoEntity add(FuncionarioServicoEntity funcionario);

    FuncionarioServicoEntity findById(Integer id);

    void delete(Integer id);

    FuncionarioServicoEntity updateFuncionario(FuncionarioServicoEntity funcionario);

}