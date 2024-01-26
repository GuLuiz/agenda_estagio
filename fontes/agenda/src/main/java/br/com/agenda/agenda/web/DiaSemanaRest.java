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

import br.com.agenda.agenda.entities.DiaSemanaEntity;
import br.com.agenda.agenda.services.interfaces.IDiaSemanaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/diaSemana")
public class DiaSemanaRest {
    
    @Autowired
    private IDiaSemanaService diaSemanaService;

    @GetMapping("/listar")
    public ResponseEntity<List<DiaSemanaEntity>> findAll() {

        return ResponseEntity.ok().body(diaSemanaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public DiaSemanaEntity findById(@PathVariable Integer id) {
        DiaSemanaEntity result = diaSemanaService.findById(id);
        return result;
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<DiaSemanaEntity> add(@RequestBody DiaSemanaEntity dia) {

        dia = diaSemanaService.add(dia);
        return ResponseEntity.ok().body(dia);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        diaSemanaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<DiaSemanaEntity> updateUsuario(@RequestBody DiaSemanaEntity dia) {

        DiaSemanaEntity diaSemanaAtualizado = diaSemanaService.add(dia);
        return ResponseEntity.ok().body(diaSemanaAtualizado);

    }
}
