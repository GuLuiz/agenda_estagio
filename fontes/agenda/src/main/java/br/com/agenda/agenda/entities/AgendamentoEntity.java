package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "AGENDAMENTO")
public class AgendamentoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agendamentoId;
    
    private Integer clienteId;
    private Integer funcionarioId;
    private Date data;
    private LocalTime horario; 
    private Boolean ativo;
    
    @OneToMany(mappedBy = "agendamento")
    private List<ServicoEntity> servicoId = new ArrayList<ServicoEntity>();

    @OneToOne(mappedBy = "agendamento")
    private EmpresaEntity empresa;
}
