package br.com.agenda.agenda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.services.interfaces.IUsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioRest {

    @Autowired
    private IUsuarioService usuarioService;


    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioEntity>> findAll() {

        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public UsuarioEntity findById(@PathVariable Integer id) {
        UsuarioEntity result = usuarioService.findById(id);
        return result;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioEntity> add(@RequestBody UsuarioEntity usuarioEntity) {

        usuarioEntity = usuarioService.add(usuarioEntity);
        return ResponseEntity.ok().body(usuarioEntity);

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<UsuarioEntity> updateUsuario(@RequestBody UsuarioEntity data) {

        UsuarioEntity usuarioAtualizado = usuarioService.add(data);
        return ResponseEntity.ok().body(usuarioAtualizado);

    }

    @PutMapping("/updateNomeEmail")
    public ResponseEntity<UsuarioEntity> updateNomeEmail(@RequestBody UsuarioEntity data) {

        UsuarioEntity usuarioAtualizado = usuarioService.findById(data.getId());
        usuarioAtualizado.setNome(data.getNome());
        usuarioAtualizado.setEmail(data.getEmail());
        usuarioAtualizado = usuarioService.add(usuarioAtualizado);
        return ResponseEntity.ok().body(usuarioAtualizado);

    }

    record Usuario (String nome, String email, Integer id){}

    @PutMapping("/updateNomeEmail2")
    public ResponseEntity<UsuarioEntity> updateNomeEmail2(@RequestBody Usuario data) {

        UsuarioEntity usuarioAtualizado = usuarioService.findById(data.id());
        usuarioAtualizado.setNome(data.nome());
        usuarioAtualizado.setEmail(data.email());
        usuarioAtualizado = usuarioService.add(usuarioAtualizado);
        return ResponseEntity.ok().body(usuarioAtualizado);

    }
}
