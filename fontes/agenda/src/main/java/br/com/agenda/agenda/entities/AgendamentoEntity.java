package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "agendamento")
@Table(name = "TB_AGENDAMENTO")
public class AgendamentoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    
    private int cliente_id;
    private int empresa_id;
    private int servico_id;
    private int funcionario_id;
    private Date data;
    private LocalDateTime horario; 
    private boolean ativo;
   
    public AgendamentoEntity(int id, int cliente_id, int empresa_id, int servico_id, int funcionario_id, Date data,
            LocalDateTime horario, boolean ativo) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.empresa_id = empresa_id;
        this.servico_id = servico_id;
        this.funcionario_id = funcionario_id;
        this.data = data;
        this.horario = horario;
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
        AgendamentoEntity other = (AgendamentoEntity) obj;
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
