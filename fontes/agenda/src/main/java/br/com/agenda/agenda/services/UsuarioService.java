package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.DTO.RequestUsuario;
import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioEntity> findAll() {
        return usuarioRepository.findAll();
    }

    public UsuarioEntity add(UsuarioEntity usuarioEntity) {

        usuarioEntity = usuarioRepository.save(usuarioEntity);

        return usuarioEntity;
    }

    public UsuarioEntity findById(Integer id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioEntity updateUsuario(@RequestBody @Valid RequestUsuario data) {

        UsuarioEntity usuario = usuarioRepository.findById(data.id()).orElse(null);

        usuario.setId(data.id());
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
