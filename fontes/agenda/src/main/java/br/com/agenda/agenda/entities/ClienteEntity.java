package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity(name = "cliente")
@Table(name = "TB_CLIENTE")
public class ClienteEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private String nome;
    private int telefone;
    @Email
    private String email;

    @Length(min = 8, max = 100, message = "A senha deve conter entre 8 a 100 caracteres")
    private String senha;

    private Date data_nascimento;
    private String descricao;
    private boolean ativo;
    
    public ClienteEntity(int id, String nome, int telefone, @Email String email,
            @Length(min = 8, max = 100, message = "A senha deve conter entre 8 a 100 caracteres") String senha,
            Date data_nascimento, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.ativo = ativo;
    }

    public ClienteEntity(int id, String nome, int telefone, @Email String email,
            @Length(min = 8, max = 100, message = "A senha deve conter entre 8 a 100 caracteres") String senha,
            Date data_nascimento, String descricao, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.descricao = descricao;
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
        ClienteEntity other = (ClienteEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    
    
    
}
