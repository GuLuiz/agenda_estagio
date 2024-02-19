package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.FuncionarioMenuEntity;
import br.com.agenda.agenda.repositories.FuncionarioMenuRepository;
import br.com.agenda.agenda.services.interfaces.IFuncionarioMenuService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FuncionarioMenuServiceImpl implements IFuncionarioMenuService {
    
    @Autowired
    private FuncionarioMenuRepository repository;

    @Override
    public List<FuncionarioMenuEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public FuncionarioMenuEntity add(FuncionarioMenuEntity menu) {

        menu = repository.save(menu);

        return menu;
    }

    @Override
    public FuncionarioMenuEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public FuncionarioMenuEntity updateFuncionarioMenu(@RequestBody FuncionarioMenuEntity funcMenu) {

         funcMenu = repository.findById(funcMenu.getFuncionarioMenuId()).orElse(null);

        funcMenu.setFuncionarioId(funcMenu.getFuncionarioId());
        funcMenu.setFuncionarioMenuId(funcMenu.getFuncionarioMenuId());
        funcMenu.setMenuId(funcMenu.getMenuId());

        funcMenu = repository.save(funcMenu);
        return funcMenu;
    }
}
