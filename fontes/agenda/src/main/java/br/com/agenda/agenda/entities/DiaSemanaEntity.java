package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DIA_SEMANA")
public class DiaSemanaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diaSemanaId;
    @Length(max = 13)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Disponibilidades", joinColumns = @JoinColumn(name = "dia_semana_id"), 
    inverseJoinColumns = @JoinColumn(name= "disponibilidade_id") )
    @JsonIgnore
    private Set<DisponibilidadeEntity> disponibilidade;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Dia_Hora_Bloqueados", joinColumns = @JoinColumn(name = "dia_semana_id"), 
    inverseJoinColumns = @JoinColumn(name= "horario_bloqueado_id") )
    @JsonIgnore
    private Set<HorarioBloqueadoEntity> horarioBloqueado;
}
