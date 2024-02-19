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

import br.com.agenda.agenda.entities.HorarioBloqueadoEntity;
import br.com.agenda.agenda.services.interfaces.IHorarioBloqueadoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/horarioBloqueado")
public class HorarioBloqueadoRest {
    
    @Autowired
    private IHorarioBloqueadoService horarioBloqueadoService;


     @GetMapping("/listar")
    public ResponseEntity<List<HorarioBloqueadoEntity>> findAll() {

        return ResponseEntity.ok().body(horarioBloqueadoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<HorarioBloqueadoEntity> findById(@PathVariable Integer id) {
        HorarioBloqueadoEntity result = horarioBloqueadoService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<HorarioBloqueadoEntity> add(@RequestBody HorarioBloqueadoEntity horarioBloqueadoEntity) {

        horarioBloqueadoEntity = horarioBloqueadoService.add(horarioBloqueadoEntity);
        return ResponseEntity.ok().body(horarioBloqueadoEntity);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteHorarioBloqueado(@PathVariable int id) {

        horarioBloqueadoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<HorarioBloqueadoEntity> updateHorarioBloqueado(@RequestBody HorarioBloqueadoEntity horarioBloqueado) {

        HorarioBloqueadoEntity horarioBloqueadoAtualizado = horarioBloqueadoService.add(horarioBloqueado);
        return ResponseEntity.ok().body(horarioBloqueadoAtualizado);
    }
}
