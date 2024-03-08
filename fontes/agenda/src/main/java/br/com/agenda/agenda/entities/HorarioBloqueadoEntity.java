package br.com.agenda.agenda.entities;


import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private LocalTime horario_inicio;
    private LocalTime horario_final;


    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    @JsonIgnore
    private FuncionarioEntity funcionario;

    @ManyToMany(mappedBy = "horarioBloqueado")
    private Set<DiaSemanaEntity> diaSemana;
    
}
