package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "CLIENTE")
public class ClienteEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String nome;
    @Length(max = 19, message = "O campo deve conter até 19 dígitos")
    private String telefone;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    @Email
    private String email;

    @Length(min = 8, max = 100, message = "A senha deve conter entre 8 a 100 caracteres")
    private String senha;

    private Date data_nascimento;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String descricao;
    
    private boolean ativo;

}
