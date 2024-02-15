package br.com.agenda.agenda.entities;


import java.io.Serializable;
import java.time.LocalTime;

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
    private Integer horarioBloqueadoId;
    private Integer dia_semana_id;
    private LocalTime horario_inicio;
    private LocalTime horario_final;
    private Integer funcionario_id;
    
}
