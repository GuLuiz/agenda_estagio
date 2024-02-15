package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.HorarioBloqueadoEntity;
import br.com.agenda.agenda.repositories.HorarioBloqueadoRepository;
import br.com.agenda.agenda.services.interfaces.IHorarioBloqueadoService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class HorarioBloqueadoServiceImpl implements IHorarioBloqueadoService {
    
    @Autowired
    private HorarioBloqueadoRepository repository;

    @Override
    public List<HorarioBloqueadoEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public HorarioBloqueadoEntity add(HorarioBloqueadoEntity horarioBloq) {

        horarioBloq = repository.save(horarioBloq);

        return horarioBloq;
    }

    @Override
    public HorarioBloqueadoEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public HorarioBloqueadoEntity updateHorarioBloqueado(@RequestBody HorarioBloqueadoEntity horarioBloq) {

        horarioBloq = repository.findById(horarioBloq.getHorarioBloqueadoId()).orElse(null);

        horarioBloq.setDia_semana_id(horarioBloq.getDia_semana_id());
        horarioBloq.setFuncionario_id(horarioBloq.getFuncionario_id());
        horarioBloq.setHorario_final(horarioBloq.getHorario_final());
        horarioBloq.setHorario_inicio(horarioBloq.getHorario_inicio());
        horarioBloq.setHorarioBloqueadoId(horarioBloq.getHorarioBloqueadoId());

        horarioBloq = repository.save(horarioBloq);
        return horarioBloq;
    }
}
