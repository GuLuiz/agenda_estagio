package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;

@NoArgsConstructor
@Entity
@Data
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String nome;
    
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    @Email
    private String email;

    @Length(min = 6, max = 30, message = "A senha deve conter entre 6 a 30 caracteres")
    private String senha;
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
    @Length(min = 8, max = 9, message = "O cep deve conter 9 dígitos")
    private String cep;
    @Length(max = 19, message = "O campo deve conter até 19 dígitos")
    private String telefone;
    private Boolean ativo;
   
    @OneToMany(mappedBy = "usuarioEntity")
    private List<EmpresaEntity> empresas = new ArrayList<EmpresaEntity>();

}
