package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;


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

    public UsuarioEntity findById(Integer id){

        return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public void delete(Integer id){
      usuarioRepository.deleteById(id);
    }

}
