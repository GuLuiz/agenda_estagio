package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.EmpresaEntity;
import br.com.agenda.agenda.repositories.EmpresaRepository;
import br.com.agenda.agenda.services.interfaces.IEmpresaService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Override
    public List<EmpresaEntity> findAll() {
        return repository.findAll();
    }
    
    @Override
    public EmpresaEntity add(EmpresaEntity empresa) {

        empresa = repository.save(empresa);

        return empresa;
    }

    @Override
    public EmpresaEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public EmpresaEntity updateEmpresa(@RequestBody EmpresaEntity empresa) {

        empresa = repository.findById(empresa.getEmpresaId()).orElse(null);

        empresa.setAtivo(empresa.getAtivo());
        empresa.setBairro(empresa.getBairro());
        empresa.setCep(empresa.getCep());
        empresa.setCidade(empresa.getCidade());
        empresa.setComplemento(empresa.getComplemento());
        empresa.setEmpresaId(empresa.getEmpresaId());
        empresa.setLogo_id(empresa.getLogo_id());
        empresa.setLogradouro(empresa.getLogradouro());
        empresa.setNome(empresa.getNome());
        empresa.setNumero(empresa.getNumero());
        empresa.setUf(empresa.getUf());

        empresa = repository.save(empresa);
        return empresa;
    }
}
