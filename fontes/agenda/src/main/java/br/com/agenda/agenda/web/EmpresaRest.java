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

import br.com.agenda.agenda.entities.EmpresaEntity;
import br.com.agenda.agenda.services.interfaces.IEmpresaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/empresa")
public class EmpresaRest {

    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/listar")
    public ResponseEntity<List<EmpresaEntity>> findAll() {

        return ResponseEntity.ok().body(empresaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaEntity> findById(@PathVariable Integer id) {
        EmpresaEntity result = empresaService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<EmpresaEntity> add(@RequestBody EmpresaEntity empresaEntity) {

        empresaEntity = empresaService.add(empresaEntity);
        return ResponseEntity.ok().body(empresaEntity);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        empresaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<EmpresaEntity> updateUsuario(@RequestBody EmpresaEntity empresa) {

        EmpresaEntity empresaAtualizada = empresaService.add(empresa);
        return ResponseEntity.ok().body(empresaAtualizada);
    }
}
