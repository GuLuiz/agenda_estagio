package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.UsuarioRepository;
import br.com.agenda.agenda.services.interfaces.IUsuarioService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity add(UsuarioEntity usuarioEntity) {

        usuarioEntity = usuarioRepository.save(usuarioEntity);

        return usuarioEntity;
    }

    @Override
    public UsuarioEntity findById(Integer id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioEntity updateUsuario(@RequestBody UsuarioEntity data) {

        UsuarioEntity usuario = usuarioRepository.findById(data.getId()).orElse(null); 

        usuario.setId(data.getId());
        usuario.setNome(data.getNome());
        usuario.setAtivo(data.getAtivo());
        usuario.setBairro(data.getBairro());
        usuario.setCep(data.getCep());
        usuario.setCidade(data.getCidade());
        usuario.setComplemento(data.getComplemento());
        usuario.setEmail(data.getEmail());
        usuario.setLogradouro(data.getLogradouro());
        usuario.setNumero(data.getNumero());
        usuario.setSenha(data.getSenha());
        usuario.setTelefone(data.getTelefone());
        usuario.setUf(data.getUf());

        data = usuarioRepository.save(usuario);
        return data;
    }
}
