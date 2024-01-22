package br.com.agenda.agenda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.agenda.DTO.RequestUsuario;
import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.UsuarioRepository;
import br.com.agenda.agenda.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository repository;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioEntity>> findAll() {

        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping(value = "/listar/{id}")
    public UsuarioEntity findById(@PathVariable Integer id) {
        UsuarioEntity result = usuarioService.findById(id);
        return result;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioEntity> add(@RequestBody UsuarioEntity usuarioEntity) {

        usuarioEntity = usuarioService.add(usuarioEntity);
        return ResponseEntity.ok().body(usuarioEntity);

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUsuario(@PathVariable int id) {

        usuarioService.delete(id);
        return "usuario deletado com sucesso";
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody @Valid RequestUsuario data) {

        UsuarioEntity usuarioAtualizado = usuarioService.updateUsuario(data);
        return ResponseEntity.ok().body(usuarioAtualizado);

    }
}
