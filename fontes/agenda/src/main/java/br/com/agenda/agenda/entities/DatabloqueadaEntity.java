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
@Entity(name = "dataBloqueada")
@Table(name = "TB_DATA_BLOQUEADA")
public class DatabloqueadaEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    
    private Date data;
    private LocalDateTime horario_inicio;
    private LocalDateTime horario_final;
    private int funcinario_id;
   
    public DatabloqueadaEntity(int id, Date data, LocalDateTime horario_inicio, LocalDateTime horario_final,
            int funcinario_id) {
        this.id = id;
        this.data = data;
        this.horario_inicio = horario_inicio;
        this.horario_final = horario_final;
        this.funcinario_id = funcinario_id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DatabloqueadaEntity other = (DatabloqueadaEntity) obj;
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
