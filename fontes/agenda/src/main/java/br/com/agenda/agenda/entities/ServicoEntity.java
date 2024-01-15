package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.security.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "servico")
@Table(name = "TB_SERVICO")
public class ServicoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private String nome;
    private double preco;
    private Timestamp tempo; //verificar com o pedro



    public ServicoEntity(int id, String nome, double preco, Timestamp tempo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.tempo = tempo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ServicoEntity other = (ServicoEntity) obj;
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
