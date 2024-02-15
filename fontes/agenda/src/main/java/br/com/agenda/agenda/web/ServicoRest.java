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

import br.com.agenda.agenda.entities.ServicoEntity;
import br.com.agenda.agenda.services.interfaces.IServicoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/servico")
public class ServicoRest {

    @Autowired
    private IServicoService servicoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ServicoEntity>> findAll() {

        return ResponseEntity.ok().body(servicoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServicoEntity> findById(@PathVariable Integer id) {
        ServicoEntity result = servicoService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<ServicoEntity> add(@RequestBody ServicoEntity servicoEntity) {

        servicoEntity = servicoService.add(servicoEntity);
        return ResponseEntity.ok().body(servicoEntity);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        servicoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<ServicoEntity> updateUsuario(@RequestBody ServicoEntity servico) {

        ServicoEntity servicoAtualizado = servicoService.add(servico);
        return ResponseEntity.ok().body(servicoAtualizado);
    }
}
