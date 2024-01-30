package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.ImagemEntity;

public interface IImagemService {

    List<ImagemEntity> findAll();

    ImagemEntity add(ImagemEntity img);

    ImagemEntity findById(Integer id);

    void delete(Integer id);

    ImagemEntity updateUsuario(ImagemEntity img);

}