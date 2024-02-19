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

import br.com.agenda.agenda.entities.FuncionarioServicoEntity;
import br.com.agenda.agenda.services.interfaces.IFuncionarioServicoService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/funcionarioServico")
public class FuncionarioServicoRest {
    
    @Autowired
    private IFuncionarioServicoService funcionarioServicoService;

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioServicoEntity>> findAll() {

        return ResponseEntity.ok().body(funcionarioServicoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioServicoEntity> findById(@PathVariable Integer id) {
        FuncionarioServicoEntity result = funcionarioServicoService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<FuncionarioServicoEntity> add(@RequestBody FuncionarioServicoEntity funcionario) {

        funcionario= funcionarioServicoService.add(funcionario);
        return ResponseEntity.ok().body(funcionario);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable int id) {

        funcionarioServicoService.delete(id);
        return ResponseEntity.ok().build();
    }

     @Transactional
    @PutMapping("/update")
    public ResponseEntity<FuncionarioServicoEntity> updateFuncionarioServico(@RequestBody FuncionarioServicoEntity funcionario) {

        FuncionarioServicoEntity funcionarioAtualizado = funcionarioServicoService.add(funcionario);
        return ResponseEntity.ok().body(funcionarioAtualizado);
    }
}
