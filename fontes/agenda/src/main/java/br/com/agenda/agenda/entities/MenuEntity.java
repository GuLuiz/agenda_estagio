package br.com.agenda.agenda.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "MENU")
@Entity
public class MenuEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;
    @Length(max = 100, message = "Limite de 100 caracteres excedido") 
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_menu_id")
    @JsonIgnore
    private FuncionarioMenuEntity funcionarioMenu;
}
