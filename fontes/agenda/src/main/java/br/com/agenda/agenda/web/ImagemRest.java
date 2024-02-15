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

import br.com.agenda.agenda.entities.ImagemEntity;
import br.com.agenda.agenda.services.interfaces.IImagemService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/imagem")
public class ImagemRest {

    @Autowired
    private IImagemService imagemService;

    @GetMapping("/listar")
    public ResponseEntity<List<ImagemEntity>> findAll() {

        return ResponseEntity.ok().body(imagemService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImagemEntity> findById(@PathVariable Integer id) {
        ImagemEntity result = imagemService.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<ImagemEntity> add(@RequestBody ImagemEntity imagemEntity) {

        imagemEntity = imagemService.add(imagemEntity);
        return ResponseEntity.ok().body(imagemEntity);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        imagemService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<ImagemEntity> updateUsuario(@RequestBody ImagemEntity imagem) {

        ImagemEntity imagemAtualizado = imagemService.add(imagem);
        return ResponseEntity.ok().body(imagemAtualizado);
    }

    
}
