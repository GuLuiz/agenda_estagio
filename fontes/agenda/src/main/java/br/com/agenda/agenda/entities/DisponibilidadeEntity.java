package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DISPONIBILIDADE")
public class DisponibilidadeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer disponibilidadeId;
    private LocalTime horario_inicio;
    private LocalTime horario_final;
    
    
    @ManyToMany(mappedBy = "disponibilidade")
    private Set<DiaSemanaEntity> diaSemana;
    
    @OneToMany(mappedBy = "disponibilidade")
    private List<FuncionarioEntity> funcionario = new ArrayList<FuncionarioEntity>();
}
