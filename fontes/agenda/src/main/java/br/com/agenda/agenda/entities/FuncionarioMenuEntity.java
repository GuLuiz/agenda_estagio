package br.com.agenda.agenda.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "funcionarioMenu")
@Table(name = "TB_FUNCIONARIO_MENU")
public class FuncionarioMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    
    private int menu_id;
    private int funcionario_id;
   
    public FuncionarioMenuEntity(int id, int menu_id, int funcionario_id) {
        this.id = id;
        this.menu_id = menu_id;
        this.funcionario_id = funcionario_id;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FuncionarioMenuEntity other = (FuncionarioMenuEntity) obj;
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
