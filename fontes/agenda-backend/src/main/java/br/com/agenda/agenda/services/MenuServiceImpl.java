package br.com.agenda.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.agenda.agenda.entities.MenuEntity;
import br.com.agenda.agenda.repositories.MenuRepository;
import br.com.agenda.agenda.services.interfaces.IMenuService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public List<MenuEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public MenuEntity add(MenuEntity menu) {

        menu = repository.save(menu);

        return menu;
    }

    @Override
    public MenuEntity findById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public MenuEntity updateUsuario(@RequestBody MenuEntity menu) {

        menu = repository.findById(menu.getId()).orElse(null);

        menu.setId(menu.getId());
        menu.setNome(menu.getNome());

        menu = repository.save(menu);
        return menu;
    }
}
