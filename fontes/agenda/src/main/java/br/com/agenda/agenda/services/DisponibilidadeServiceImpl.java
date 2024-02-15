package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.DisponibilidadeEntity;
import br.com.agenda.agenda.repositories.DisponibilidadeRepository;
import br.com.agenda.agenda.services.interfaces.IDisponibilidadeService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DisponibilidadeServiceImpl implements IDisponibilidadeService {
    
    @Autowired
    private DisponibilidadeRepository repository;

     @Override
    public List<DisponibilidadeEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public DisponibilidadeEntity add(DisponibilidadeEntity disp) {

        disp = repository.save(disp);

        return disp;
    }

    @Override
    public DisponibilidadeEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

     @Override
    public DisponibilidadeEntity updateDisponibilidade(@RequestBody DisponibilidadeEntity disp) {

        disp = repository.findById(disp.getDisponibilidadeId()).orElse(null);

        disp.setDisponibilidadeId(disp.getDisponibilidadeId());
        disp.setDia_semana_id(disp.getDia_semana_id());
        disp.setFuncionario_id(disp.getFuncionario_id());
        disp.setHorario_inicio(disp.getHorario_inicio());
        disp.setHorario_final(disp.getHorario_final());
        return disp;
    }
}
