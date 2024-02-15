package br.com.agenda.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.DTO.RequestUsuario;
import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.UsuarioRepository;
import br.com.agenda.agenda.services.interfaces.IUsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

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

        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
        
        return usuarioEntity;
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioEntity updateUsuario(@RequestBody @Valid RequestUsuario data) {

        UsuarioEntity usuario = usuarioRepository.findById(data.id()).orElse(null);

        usuario.setUsuarioId(data.id());
        usuario.setNome(data.nome());
        usuario.setAtivo(data.ativo());
        usuario.setBairro(data.bairro());
        usuario.setCep(data.cep());
        usuario.setCidade(data.cidade());
        usuario.setComplemento(data.complemento());
        usuario.setEmail(data.email());
        usuario.setLogradouro(data.logradouro());
        usuario.setNumero(data.numero());
        usuario.setSenha(data.senha());
        usuario.setTelefone(data.telefone());
        usuario.setUf(data.uf());

        UsuarioEntity usuarioAtualizado = usuarioRepository.save(usuario);
        return usuarioAtualizado;
    }
}
