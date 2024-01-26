package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.DataBloqueadaEntity;
import br.com.agenda.agenda.repositories.DataBloqueadaRepository;
import br.com.agenda.agenda.services.interfaces.IDataBloqueadaService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DataBloqueadaServiceImpl implements IDataBloqueadaService {
 
    @Autowired
    private DataBloqueadaRepository repository;

    @Override
    public List<DataBloqueadaEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public DataBloqueadaEntity add(DataBloqueadaEntity data) {

        data = repository.save(data);

        return data;
    }
    @Override
    public DataBloqueadaEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public DataBloqueadaEntity updateUsuario(@RequestBody DataBloqueadaEntity data) {

        data = repository.findById(data.getId()).orElse(null);

        data.setData(data.getData());
        data.setFuncinario_id(data.getFuncinario_id());
        data.setHorario_final(data.getHorario_final());
        data.setHorario_inicio(data.getHorario_inicio());
        data.setId(data.getId());
        data = repository.save(data);
        return data;
    }



}
