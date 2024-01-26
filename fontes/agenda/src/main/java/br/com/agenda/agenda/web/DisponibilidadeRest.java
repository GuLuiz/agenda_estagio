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
import br.com.agenda.agenda.entities.DisponibilidadeEntity;
import br.com.agenda.agenda.services.interfaces.IDisponibilidadeService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeRest {
    
    @Autowired
    private IDisponibilidadeService disponibilidadeService;

    @GetMapping("/listar")
    public ResponseEntity<List<DisponibilidadeEntity>> findAll() {

        return ResponseEntity.ok().body(disponibilidadeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public DisponibilidadeEntity findById(@PathVariable Integer id) {
        DisponibilidadeEntity result = disponibilidadeService.findById(id);
        return result;
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<DisponibilidadeEntity> add(@RequestBody DisponibilidadeEntity disp) {

        disp = disponibilidadeService.add(disp);
        return ResponseEntity.ok().body(disp);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        disponibilidadeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<DisponibilidadeEntity> updateDisponibilidade(@RequestBody DisponibilidadeEntity disp) {

        DisponibilidadeEntity disponibilidadeAtualizado = disponibilidadeService.add(disp);
        return ResponseEntity.ok().body(disponibilidadeAtualizado);

    }
}
