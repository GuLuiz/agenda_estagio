package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.FuncionarioEntity;
import br.com.agenda.agenda.repositories.FuncionarioRepository;
import br.com.agenda.agenda.services.interfaces.IFuncionarioService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioServiceImpl implements IFuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public List<FuncionarioEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public FuncionarioEntity add(FuncionarioEntity funcionario) {

        funcionario = repository.save(funcionario);

        return funcionario;
    }

    @Override
    public FuncionarioEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public FuncionarioEntity updateUsuario(@RequestBody FuncionarioEntity funcionario) {

        funcionario = repository.findById(funcionario.getId()).orElse(null);

        funcionario.setAtivo(funcionario.getAtivo());
        funcionario.setEmail(funcionario.getEmail());
        funcionario.setEmpresa_id(funcionario.getEmpresa_id());
        funcionario.setFoto_id(funcionario.getFoto_id());
        funcionario.setId(funcionario.getId());
        funcionario.setNome(funcionario.getNome());
        funcionario.setSenha(funcionario.getSenha());
        funcionario.setTelefone(funcionario.getTelefone());

        funcionario = repository.save(funcionario);
        return funcionario;
    }
}
