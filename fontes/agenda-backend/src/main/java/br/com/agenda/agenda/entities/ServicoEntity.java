package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.time.LocalTime;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SERVICO")
public class ServicoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String nome;
    private Double preco;
    private LocalTime tempo;

}
