package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.DataBloqueadaEntity;

public interface IDataBloqueadaService {

    List<DataBloqueadaEntity> findAll();

    DataBloqueadaEntity add(DataBloqueadaEntity data);

    DataBloqueadaEntity findById(Integer id);

    void delete(Integer id);

    DataBloqueadaEntity updateDataBloqueada(DataBloqueadaEntity data);

}