package br.com.agenda.agenda.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "TB_EMPRESA")
@Entity(name = "empresa")
public class EmpresaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    @Column(unique=true)
    private String nome;
    private String logradouro;
    private int numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    @Length(min = 6, max = 6, message = "O cep deve conter 6 dígitos")
    private int cep;
    private int usuario_id;
    private int logo_id;
    private boolean ativo;

    
    public EmpresaEntity(int id, String nome, String logradouro, int numero, String bairro, String complemento,
            String cidade, String uf, @Length(min = 6, max = 6, message = "O cep deve conter 6 dígitos") int cep,
            int usuario_id, int logo_id, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.usuario_id = usuario_id;
        this.logo_id = logo_id;
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
        EmpresaEntity other = (EmpresaEntity) obj;
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
