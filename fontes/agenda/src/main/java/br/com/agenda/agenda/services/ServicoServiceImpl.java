package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.ServicoEntity;
import br.com.agenda.agenda.repositories.ServicoRepository;
import br.com.agenda.agenda.services.interfaces.IServicoService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoServiceImpl implements IServicoService {
    
    @Autowired
    private ServicoRepository repository;

    @Override
    public List<ServicoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ServicoEntity add(ServicoEntity servico) {

        servico = repository.save(servico);

        return servico;
    }

    @Override
    public ServicoEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ServicoEntity updateUsuario(@RequestBody ServicoEntity servico) {

        servico = repository.findById(servico.getId()).orElse(null);

        servico.setId(servico.getId());
        servico.setNome(servico.getNome());
        servico.setPreco(servico.getPreco());
        servico.setTempo(servico.getTempo());
        
        servico = repository.save(servico);
        return servico;
    }
}
