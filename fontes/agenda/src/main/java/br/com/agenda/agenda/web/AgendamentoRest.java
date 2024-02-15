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

import br.com.agenda.agenda.entities.AgendamentoEntity;
import br.com.agenda.agenda.services.interfaces.IAgendamentoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoRest {
    
    @Autowired
    private IAgendamentoService agendamentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<AgendamentoEntity>> findAll() {

         return ResponseEntity.ok().body(agendamentoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoEntity> findById(@PathVariable Integer id) {
        AgendamentoEntity result = agendamentoService.findById(id);
        return ResponseEntity.ok().body(result);
    }   

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<AgendamentoEntity> add(@RequestBody AgendamentoEntity agendamentoEntity) {

        agendamentoEntity = agendamentoService.add(agendamentoEntity);
        return ResponseEntity.ok().body(agendamentoEntity);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        agendamentoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<AgendamentoEntity> updateUsuario(@RequestBody AgendamentoEntity agenda) {

        AgendamentoEntity agendaAtualizado = agendamentoService.add(agenda);
        return ResponseEntity.ok().body(agendaAtualizado);
    }

    
}
