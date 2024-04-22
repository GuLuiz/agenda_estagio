package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.ClienteEntity;

public interface IClienteService {

    List<ClienteEntity> findAll();

    ClienteEntity add(ClienteEntity cliente);

    ClienteEntity findById(Integer id);

    void delete(Integer id);

    ClienteEntity updateUsuario(ClienteEntity cliente);

}