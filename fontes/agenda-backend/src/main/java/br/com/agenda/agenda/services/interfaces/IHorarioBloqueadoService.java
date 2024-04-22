package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.HorarioBloqueadoEntity;

public interface IHorarioBloqueadoService {

    List<HorarioBloqueadoEntity> findAll();

    HorarioBloqueadoEntity add(HorarioBloqueadoEntity horarioBloq);

    HorarioBloqueadoEntity findById(Integer id);

    void delete(Integer id);

    HorarioBloqueadoEntity updateUsuario(HorarioBloqueadoEntity horarioBloq);

}