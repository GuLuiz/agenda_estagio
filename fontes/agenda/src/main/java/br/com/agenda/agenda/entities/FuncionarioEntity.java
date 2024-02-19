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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "FUNCIONARIO")
public class FuncionarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer funcionarioId;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String nome;
    @Length(max = 19, message = "O cep deve conter até 19 dígitos")
    private String telefone;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    @Email
    private String email;
    @Length(min = 6, max = 30, message = "A senha deve conter entre 6 a 30 caracteres")
    private String senha;
    private Integer foto_id;
    private Integer empresa_id;
    private Boolean ativo;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_servico_id")
    @JsonIgnore
    private FuncionarioServicoEntity funcionarioServico;
}
