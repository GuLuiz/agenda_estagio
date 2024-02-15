package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.AgendamentoEntity;

public interface IAgendamentoService {

    List<AgendamentoEntity> findAll();

    AgendamentoEntity add(AgendamentoEntity agenda);

    AgendamentoEntity findById(Integer id);

    void delete(Integer id);

    AgendamentoEntity updateAgendamento(AgendamentoEntity agenda);

}