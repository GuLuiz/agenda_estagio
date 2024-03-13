package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.DiaSemanaEntity;
import br.com.agenda.agenda.repositories.DiaSemanaRepository;
import br.com.agenda.agenda.services.interfaces.IDiaSemanaService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DiaSemanaServiceImpl implements IDiaSemanaService {

    @Autowired
    DiaSemanaRepository repository;

    @Override
    public List<DiaSemanaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public DiaSemanaEntity add(DiaSemanaEntity dia) {

        dia = repository.save(dia);

        return dia;
    }

    @Override
    public DiaSemanaEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }
    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public DiaSemanaEntity updateDiaSemana(@RequestBody DiaSemanaEntity dia) {

        dia = repository.findById(dia.getDiaSemanaId()).orElse(null);

        dia.setDiaSemanaId(dia.getDiaSemanaId());
        dia.setName(dia.getName());
        
        return dia;
    }

}
