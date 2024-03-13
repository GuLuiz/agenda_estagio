package br.com.agenda.agenda.entities;

import java.io.Serializable;
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
@Table(name = "FUNCIONARIO_SERVICO")
public class FuncionarioServicoEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer funcionarioServicoId;

    
    
    @OneToMany(mappedBy = "funcionarioServico")
    private List<ServicoEntity> servico = new ArrayList<ServicoEntity>();

    @OneToOne(mappedBy = "funcionarioServico")
    private FuncionarioEntity funcionario;
}
