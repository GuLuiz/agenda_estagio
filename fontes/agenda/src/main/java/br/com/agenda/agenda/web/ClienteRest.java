package br.com.agenda.agenda.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.agenda.entities.ClienteEntity;
import br.com.agenda.agenda.services.interfaces.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRest {

    @Autowired
    private IClienteService clienteService;

     @GetMapping("/listar")
    public ResponseEntity<List<ClienteEntity>> findAll() {

        return ResponseEntity.ok().body(clienteService.findAll());
    }
}
