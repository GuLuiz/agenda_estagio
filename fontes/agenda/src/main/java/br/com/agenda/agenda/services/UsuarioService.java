package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.UsuarioRepository;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> findAll(){


        return usuarioRepository.findAll();
    }

    public UsuarioEntity add(UsuarioEntity usuarioEntity){

        usuarioEntity = usuarioRepository.save(usuarioEntity);
        
        return usuarioEntity;
    }

}
