package br.com.agenda.agenda.services.interfaces;

import java.util.List;

import br.com.agenda.agenda.entities.EmpresaEntity;

public interface IEmpresaService {

    List<EmpresaEntity> findAll();

    EmpresaEntity add(EmpresaEntity empresa);

    EmpresaEntity findById(Integer id);

    void delete(Integer id);

    EmpresaEntity updateEmpresa(EmpresaEntity empresa);

}