package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.AgendamentoEntity;
import br.com.agenda.agenda.repositories.AgendamentoRepository;
import br.com.agenda.agenda.services.interfaces.IAgendamentoService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendamentoServiceImpl implements IAgendamentoService {
    
    @Autowired
    private AgendamentoRepository repository;

    @Override
    public List<AgendamentoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public AgendamentoEntity add(AgendamentoEntity agenda) {

        agenda = repository.save(agenda);

        return agenda;
    }

    @Override
    public AgendamentoEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public AgendamentoEntity updateUsuario(@RequestBody AgendamentoEntity agenda) {

        agenda = repository.findById(agenda.getId()).orElse(null);

        agenda.setAtivo(agenda.getAtivo());
        agenda.setClienteId(agenda.getClienteId());
        agenda.setData(agenda.getData());
        agenda.setEmpresaId(agenda.getEmpresaId());
        agenda.setFuncionarioId(agenda.getFuncionarioId());
        agenda.setHorario(agenda.getHorario());
        agenda.setId(agenda.getId());
        agenda.setServicoId(agenda.getServicoId());
        
        agenda = repository.save(agenda);
        return agenda;
    }
}
