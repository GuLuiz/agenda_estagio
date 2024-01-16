package br.com.agenda.agenda.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.validation.constraints.Email;


@Entity(name = "candidate")
@Data
@Table(name = "TB_USUARIO")
public class UsuarioEntitiy implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String nome;
    
    @Email
    private String email;
    @Length(min = 8, max = 100, message = "A senha deve conter entre 8 a 100 caracteres")
    private String senha;
    private String Logradouro;
    private int numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    @Length(min = 6, max = 6, message = "O cep deve conter 6 dígitos")
    private int cep;
    private int telefone;
    private boolean ativo;
   
   
    public UsuarioEntitiy(Long id, String nome, String email, String senha, String logradouro, int numero, String bairro,
            String complemento, String cidade, String uf, int cep, int telefone, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        Logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.ativo = ativo;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UsuarioEntitiy other = (UsuarioEntitiy) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
