package br.com.agenda.agenda.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity(name = "funcionario")
@Table(name = "TB_FUNCIONARIO")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private String nome;
    private int telefone;
    @Email
    private String email;
    @Length(min = 8, max = 100, message = "A senha deve conter entre 8 a 100 caracteres")
    private String senha;
    private int foto_id;
    private int empresa_id;
    private boolean ativo;
    
    public FuncionarioEntity(int id, String nome, int telefone, @Email String email,
            @Length(min = 8, max = 100, message = "A senha deve conter entre 8 a 100 caracteres") String senha,
            int foto_id, int empresa_id, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.foto_id = foto_id;
        this.empresa_id = empresa_id;
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
        FuncionarioEntity other = (FuncionarioEntity) obj;
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
