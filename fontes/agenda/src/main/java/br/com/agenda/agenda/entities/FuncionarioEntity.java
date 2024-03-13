package br.com.agenda.agenda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Entity
@Table(name = "FUNCIONARIO")
public class FuncionarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer funcionarioId;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    private String nome;
    @Length(max = 19, message = "O cep deve conter até 19 dígitos")
    private String telefone;
    @Length(max = 100, message = "Limite de 100 caracteres excedido")
    @Email
    private String email;
    @Length(min = 6, max = 30, message = "A senha deve conter entre 6 a 30 caracteres")
    private String senha;
    private Integer foto_id;
    private Boolean ativo;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_servico_id")
    @JsonIgnore
    private FuncionarioServicoEntity funcionarioServico;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agendamento_id")
    @JsonIgnore
    private AgendamentoEntity agendamento;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonIgnore
    private EmpresaEntity empresa;

    @ManyToOne
    @JoinColumn(name = "disponibilidade_id")
    @JsonIgnore
    private DisponibilidadeEntity disponibilidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_menu_id")
    @JsonIgnore
    private FuncionarioMenuEntity funcionarioMenu;
    
    @OneToMany(mappedBy = "funcionario")
    private List<HorarioBloqueadoEntity> horarioBloqueado = new ArrayList<HorarioBloqueadoEntity>();

    @OneToMany(mappedBy = "funcionario")
    private List<DataBloqueadaEntity> dataBloqueada = new ArrayList<DataBloqueadaEntity>();
}
