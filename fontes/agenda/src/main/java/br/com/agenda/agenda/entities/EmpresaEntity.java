package br.com.agenda.agenda.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "EMPRESA")
@Entity
public class EmpresaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String nome;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String logradouro;
    @Length(max = 20, message = "Limite de 20 caracteres excedido")
    private String numero;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String bairro;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String complemento;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String cidade;
    @Length(max = 2, message = "UF deve conter 2 digitos")
    private String uf;
    @Length(min = 8, max = 9, message = "O cep deve conter 6 dígitos")
    private String cep;
    private Integer usuario_id;
    private Integer logo_id;
    private Boolean ativo;
 
}
