package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "disponibilidade")
@Table(name = "TB_DISPONIBILIDADE")
public class DisponibilidadeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private String dia_semana;
    private LocalDateTime horario_inicio;
    private LocalDateTime horario_final;
    private int funcionario_id;
    
    public DisponibilidadeEntity(int id, String dia_semana, LocalDateTime horario_inicio, LocalDateTime horario_final,
            int funcionario_id) {
        this.id = id;
        this.dia_semana = dia_semana;
        this.horario_inicio = horario_inicio;
        this.horario_final = horario_final;
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
        DisponibilidadeEntity other = (DisponibilidadeEntity) obj;
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
