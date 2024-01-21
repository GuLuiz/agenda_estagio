package br.com.agenda.agenda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioEntity>> findAll(){

        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioEntity> add (@RequestBody UsuarioEntity usuarioEntity){

        usuarioEntity = usuarioService.add(usuarioEntity);
        return ResponseEntity.ok().body(usuarioEntity);

    }

}
