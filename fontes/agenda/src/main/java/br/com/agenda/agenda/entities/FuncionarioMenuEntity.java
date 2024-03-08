package br.com.agenda.agenda.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "FUNCIONARIO_MENU")
public class FuncionarioMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer funcionarioMenuId;
    
    @OneToOne(mappedBy = "funcionarioMenu")
    private MenuEntity menu;

    @OneToOne(mappedBy = "funcionarioMenu")
    private FuncionarioEntity funcionario;
}
