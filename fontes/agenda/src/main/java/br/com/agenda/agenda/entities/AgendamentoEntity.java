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
@Entity
@Table(name = "AGENDAMENTO")
public class AgendamentoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer cliente_id;
    private Integer empresa_id;
    private Integer servico_id;
    private Integer funcionario_id;
    private Date data;
    private LocalDateTime horario; 
    private Boolean ativo;
}
