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
@Entity
@Table(name = "HORARIO_BLOQUEADO")
public class HorarioBloqueadoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer dia_semana_id;
    private LocalDateTime horario_inicio;
    private LocalDateTime horario_final;
    private Integer funcionario_id;
    
}
