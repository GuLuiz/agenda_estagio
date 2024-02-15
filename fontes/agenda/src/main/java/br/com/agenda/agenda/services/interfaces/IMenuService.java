package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.MenuEntity;

public interface IMenuService {

    List<MenuEntity> findAll();

    MenuEntity add(MenuEntity menu);

    MenuEntity findById(Integer id);

    void delete(Integer id);

    MenuEntity updateMenu(MenuEntity menu);

}