package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.ServicoEntity;

public interface IServicoService {

    List<ServicoEntity> findAll();

    ServicoEntity add(ServicoEntity servico);

    ServicoEntity findById(Integer id);

    void delete(Integer id);

    ServicoEntity updateServico(ServicoEntity servico);

}