package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.dto.RequestUsuario;
import br.com.agenda.agenda.entities.UsuarioEntity;

public interface IUsuarioService {

    List<UsuarioEntity> findAll();

    UsuarioEntity add(UsuarioEntity usuarioEntity);

    UsuarioEntity findById(Integer id);

    void delete(Integer id);

    UsuarioEntity updateUsuario(RequestUsuario data);

}