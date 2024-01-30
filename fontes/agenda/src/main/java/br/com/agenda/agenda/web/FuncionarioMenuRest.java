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

import br.com.agenda.agenda.entities.FuncionarioMenuEntity;
import br.com.agenda.agenda.services.interfaces.IFuncionarioMenuService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/funcionarioMenu")
public class FuncionarioMenuRest {
    
    @Autowired
    private IFuncionarioMenuService funcionarioMenuService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioMenuEntity>> findAll() {

        return ResponseEntity.ok().body(funcionarioMenuService.findAll());
    }

    @GetMapping(value = "/{id}")
    public FuncionarioMenuEntity findById(@PathVariable Integer id) {
        FuncionarioMenuEntity result = funcionarioMenuService.findById(id);
        return result;
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<FuncionarioMenuEntity> add(@RequestBody FuncionarioMenuEntity funcionarioMenuEntity) {

        funcionarioMenuEntity = funcionarioMenuService.add(funcionarioMenuEntity);
        return ResponseEntity.ok().body(funcionarioMenuEntity);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        funcionarioMenuService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<FuncionarioMenuEntity> updateUsuario(@RequestBody FuncionarioMenuEntity funcionarioMenu) {

        FuncionarioMenuEntity funcionarioMenuAtualizado = funcionarioMenuService.add(funcionarioMenu);
        return ResponseEntity.ok().body(funcionarioMenuAtualizado);
    }
}
