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

import br.com.agenda.agenda.entities.DataBloqueadaEntity;
import br.com.agenda.agenda.services.interfaces.IDataBloqueadaService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/dataBloqueada")
public class DataBloqueadaRest {
    
    @Autowired
    private IDataBloqueadaService dataBloqueadaService;

    @GetMapping("/listar")
    public ResponseEntity<List<DataBloqueadaEntity>> findAll() {

        return ResponseEntity.ok().body(dataBloqueadaService.findAll());
    }

     @GetMapping(value = "/{id}")
    public DataBloqueadaEntity findById(@PathVariable Integer id) {
        DataBloqueadaEntity result = dataBloqueadaService.findById(id);
        return result;
    }

    @Transactional
    @PostMapping("/adicionar")
    public ResponseEntity<DataBloqueadaEntity> add(@RequestBody DataBloqueadaEntity data) {

        data = dataBloqueadaService.add(data);
        return ResponseEntity.ok().body(data);
    }

    @Transactional
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {

        dataBloqueadaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<DataBloqueadaEntity> updateUsuario(@RequestBody DataBloqueadaEntity data) {

        DataBloqueadaEntity usuarioAtualizado = dataBloqueadaService.add(data);
        return ResponseEntity.ok().body(usuarioAtualizado);

    }


}
