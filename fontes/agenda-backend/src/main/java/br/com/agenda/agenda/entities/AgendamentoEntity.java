package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Column;
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
    
    @Column(name = "CLIENTE_ID")
    private Integer clienteId;
    @Column(name = "EMPRESA_ID")
    private Integer empresaId;
    @Column(name = "SERVICO_ID")
    private Integer servicoId;
    @Column(name = "FUNCIONARIO_ID")
    private Integer funcionarioId;
    private Date data;
    private LocalTime horario; 
    private Boolean ativo;
}
