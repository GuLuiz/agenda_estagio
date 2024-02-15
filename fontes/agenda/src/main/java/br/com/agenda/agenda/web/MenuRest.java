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

import br.com.agenda.agenda.entities.MenuEntity;
import br.com.agenda.agenda.services.interfaces.IMenuService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/menu")
public class MenuRest {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/listar")
    public ResponseEntity<List<MenuEntity>> findAll() {

        return ResponseEntity.ok().body(menuService.findAll());
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<MenuEntity> findById(@PathVariable Integer id) {
        MenuEntity result = menuService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<MenuEntity> add(@RequestBody MenuEntity menuEntity) {

        menuEntity = menuService.add(menuEntity);
        return ResponseEntity.ok().body(menuEntity);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        menuService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<MenuEntity> updateUsuario(@RequestBody MenuEntity menu) {

        MenuEntity menuAtualizado = menuService.add(menu);
        return ResponseEntity.ok().body(menuAtualizado);
    }
}
