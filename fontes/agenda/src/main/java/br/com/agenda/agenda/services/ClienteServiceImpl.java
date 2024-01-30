package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.ClienteEntity;
import br.com.agenda.agenda.repositories.ClienteRepository;
import br.com.agenda.agenda.services.interfaces.IClienteService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<ClienteEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ClienteEntity add(ClienteEntity cliente) {

        cliente = repository.save(cliente);

        return cliente;
    }

    @Override
    public ClienteEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ClienteEntity updateUsuario(@RequestBody ClienteEntity cliente) {

        cliente = repository.findById(cliente.getId()).orElse(null);

        cliente.setData_nascimento(cliente.getData_nascimento());
        cliente.setDescricao(cliente.getDescricao());
        cliente.setEmail(cliente.getEmail());
        cliente.setId(cliente.getId());
        cliente.setNome(cliente.getNome());
        cliente.setSenha(cliente.getSenha());
        cliente.setTelefone(cliente.getTelefone());

        cliente = repository.save(cliente);
        return cliente;
    }



}
