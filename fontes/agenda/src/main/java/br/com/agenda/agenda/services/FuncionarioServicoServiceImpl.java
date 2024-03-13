package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.FuncionarioServicoEntity;
import br.com.agenda.agenda.repositories.FuncionarioServicoRepository;
import br.com.agenda.agenda.services.interfaces.IFuncionarioServicoService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioServicoServiceImpl implements IFuncionarioServicoService {

    @Autowired
    private FuncionarioServicoRepository repository;

    @Override
    public List<FuncionarioServicoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public FuncionarioServicoEntity add(FuncionarioServicoEntity funcionario) {

        funcionario = repository.save(funcionario);

        return funcionario;
    }

    @Override
    public FuncionarioServicoEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public FuncionarioServicoEntity updateFuncionario(@RequestBody FuncionarioServicoEntity funcionario) {

        funcionario = repository.findById(funcionario.getFuncionarioServicoId()).orElse(null);

        funcionario = repository.save(funcionario);
        return funcionario;
    }
}
