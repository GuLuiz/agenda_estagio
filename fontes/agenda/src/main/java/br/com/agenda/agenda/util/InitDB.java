package br.com.agenda.agenda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.agenda.agenda.entities.AgendamentoEntity;
import br.com.agenda.agenda.entities.ClienteEntity;
import br.com.agenda.agenda.entities.DataBloqueadaEntity;
import br.com.agenda.agenda.entities.DiaSemanaEntity;
import br.com.agenda.agenda.entities.DisponibilidadeEntity;
import br.com.agenda.agenda.entities.EmpresaEntity;
import br.com.agenda.agenda.entities.FuncionarioEntity;
import br.com.agenda.agenda.entities.FuncionarioMenuEntity;
import br.com.agenda.agenda.entities.FuncionarioServicoEntity;
import br.com.agenda.agenda.entities.HorarioBloqueadoEntity;
import br.com.agenda.agenda.entities.MenuEntity;
import br.com.agenda.agenda.entities.ServicoEntity;
import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.AgendamentoRepository;
import br.com.agenda.agenda.repositories.ClienteRepository;
import br.com.agenda.agenda.repositories.DataBloqueadaRepository;
import br.com.agenda.agenda.repositories.DiaSemanaRepository;
import br.com.agenda.agenda.repositories.DisponibilidadeRepository;
import br.com.agenda.agenda.repositories.EmpresaRepository;
import br.com.agenda.agenda.repositories.FuncionarioMenuRepository;
import br.com.agenda.agenda.repositories.FuncionarioRepository;
import br.com.agenda.agenda.repositories.FuncionarioServicoRepository;
import br.com.agenda.agenda.repositories.HorarioBloqueadoRepository;
import br.com.agenda.agenda.repositories.MenuRepository;
import br.com.agenda.agenda.repositories.ServicoRepository;
import br.com.agenda.agenda.repositories.UsuarioRepository;

@Component
public class InitDB implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DataBloqueadaRepository dataBloqueadaRepository;

    @Autowired
    private DiaSemanaRepository diaSemanaRepository;

    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMenuRepository funcionarioMenuRepository;

    @Autowired
    private HorarioBloqueadoRepository horarioBloqueadoRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private FuncionarioServicoRepository funcionarioServicoRepository;

    public void inserirRegistros() {
        System.out.println("Inserindo registros");

        /* Usuario */

        UsuarioEntity usuarioEntity1 = new UsuarioEntity();
        usuarioEntity1.setUsuarioId(0);
        usuarioEntity1.setAtivo(true);
        usuarioEntity1.setBairro("Parque Itamaraty");
        usuarioEntity1.setCep("12222-600");
        usuarioEntity1.setCidade("São Paulo");
        usuarioEntity1.setComplemento("Casa dos fundos");
        usuarioEntity1.setEmail("teste@gmail.com");
        usuarioEntity1.setLogradouro("Rua das Oliveiras");
        usuarioEntity1.setNome("Gustavo Luiz");
        usuarioEntity1.setNumero("123");
        usuarioEntity1.setSenha("12345678");
        usuarioEntity1.setTelefone("(12) 99999-9878");
        usuarioEntity1.setUf("SP");

        UsuarioEntity usuarioEntity2 = new UsuarioEntity();

        usuarioEntity2.setUsuarioId(0);
        usuarioEntity2.setAtivo(true);
        usuarioEntity2.setBairro("Jardim Estrela");
        usuarioEntity2.setCep("12305-150");
        usuarioEntity2.setCidade("São José dos Campos");
        usuarioEntity2.setComplemento("Condominio 988");
        usuarioEntity2.setEmail("teste2@gmail.com");
        usuarioEntity2.setLogradouro("Avenida Andromeda");
        usuarioEntity2.setNome("Maria Eduarda");
        usuarioEntity2.setNumero("135");
        usuarioEntity2.setSenha("teste123");
        usuarioEntity2.setTelefone("(12) 98255-6589");
        usuarioEntity2.setUf("RJ");

        /* Empresa */

        EmpresaEntity empresa = new EmpresaEntity();

        empresa.setAtivo(true);
        empresa.setBairro("Centro");
        empresa.setCidade("São Paulo");
        empresa.setComplemento("quadra 3");
        empresa.setEmpresaId(0);
        empresa.setLogradouro("Rua São Dimas");
        empresa.setNome("Teste 1 LTDA");
        empresa.setNumero("991");
        empresa.setUf("SP");
        empresa.setCep("12333-600");

        usuarioEntity1 = usuarioRepository.save(usuarioEntity1);
        usuarioRepository.save(usuarioEntity2);
        empresa.setUsuarioEntity(usuarioEntity1);
        empresaRepository.save(empresa);

        /* Cliente */

        ClienteEntity clienteEntity1 = new ClienteEntity();

        clienteEntity1.setAtivo(true);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            java.util.Date dataNascimento = dateFormat.parse("11-10-2002");
            clienteEntity1.setData_nascimento(new java.sql.Date(dataNascimento.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();

        }
        clienteEntity1.setDescricao("o céu é azul");
        clienteEntity1.setEmail("cliente@gmail.com");
        clienteEntity1.setClienteId(0);
        clienteEntity1.setNome("Cliente Teste");
        clienteEntity1.setSenha("12345678");
        clienteEntity1.setTelefone("(12) 98199-9998");

        clienteRepository.save(clienteEntity1);

        /* Data Bloqueada */

        DataBloqueadaEntity dataBloqueadaEntity1 = new DataBloqueadaEntity();

        try {
            java.util.Date data = dateFormat.parse("11-10-2002");
            dataBloqueadaEntity1.setData(new java.sql.Date(data.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataBloqueadaEntity1.setFuncionario_id(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime horarioInicio = LocalTime.parse("14:50:22", formatter);
        dataBloqueadaEntity1.setHorario_inicio(horarioInicio);
        LocalTime horarioFinal = LocalTime.parse("10:50:22", formatter);
        dataBloqueadaEntity1.setHorario_final(horarioFinal);
        dataBloqueadaEntity1.setDataBloqueadaId(1);

        dataBloqueadaRepository.save(dataBloqueadaEntity1);

        /* Dia Semana */

        DiaSemanaEntity segunda = new DiaSemanaEntity();
        DiaSemanaEntity terca = new DiaSemanaEntity();
        DiaSemanaEntity quarta = new DiaSemanaEntity();
        DiaSemanaEntity quinta = new DiaSemanaEntity();
        DiaSemanaEntity sexta = new DiaSemanaEntity();
        DiaSemanaEntity sabado = new DiaSemanaEntity();
        DiaSemanaEntity domingo = new DiaSemanaEntity();

        segunda.setDiaSemanaId(0);
        segunda.setName("Segunda-Feira");
        terca.setDiaSemanaId(0);
        terca.setName("Terça-Feira");
        quarta.setDiaSemanaId(0);
        quarta.setName("Quarta-Feira");
        quinta.setDiaSemanaId(0);
        quinta.setName("Quinta-Feira");
        sexta.setDiaSemanaId(0);
        sexta.setName("Sexta-Feira");
        sabado.setDiaSemanaId(0);
        sabado.setName("Sabado");
        domingo.setDiaSemanaId(0);
        domingo.setName("Domingo");

        diaSemanaRepository.save(segunda);
        diaSemanaRepository.save(terca);
        diaSemanaRepository.save(quarta);
        diaSemanaRepository.save(quinta);
        diaSemanaRepository.save(sexta);
        diaSemanaRepository.save(sabado);
        diaSemanaRepository.save(domingo);

        /* Disponibilidade */

        DisponibilidadeEntity disponibilidade = new DisponibilidadeEntity();

        disponibilidade.setDia_semana_id(1);
        disponibilidade.setFuncionario_id(1);
        LocalTime dispHorarioInicio = LocalTime.parse("08:00:00", formatter);
        disponibilidade.setHorario_inicio(dispHorarioInicio);
        LocalTime dispHorarioFinal = LocalTime.parse("18:00:00", formatter);
        disponibilidade.setHorario_final(dispHorarioFinal);
        disponibilidade.setDisponibilidadeId(0);

        disponibilidadeRepository.save(disponibilidade);

        /* Funcionario */

        FuncionarioEntity funcionario = new FuncionarioEntity();

        funcionario.setAtivo(true);
        funcionario.setEmail("funcionario@gmail.com");
        funcionario.setEmpresa_id(1);
        funcionario.setFoto_id(1);
        funcionario.setFuncionarioId(0);
        funcionario.setNome("Funcionario 1");
        funcionario.setSenha("Senha123");
        funcionario.setTelefone("(12) 99965-1425");

        funcionarioRepository.save(funcionario);

        /* Funcionario Menu */

        FuncionarioMenuEntity funcionarioMenu = new FuncionarioMenuEntity();

        funcionarioMenu.setFuncionarioId(1);
        funcionarioMenu.setFuncionarioMenuId(0);
        funcionarioMenu.setMenuId(1);

        funcionarioMenuRepository.save(funcionarioMenu);

        /* Servico */

        ServicoEntity servico = new ServicoEntity();

        servico.setServicoId(0);
        servico.setNome("Modelo Y");
        servico.setPreco(150.00);
        LocalTime timeService = LocalTime.parse("01:00:00", formatter);
        servico.setTempo(timeService);


        /* Funcionario Servico */

        FuncionarioServicoEntity funcionarioServico = new FuncionarioServicoEntity();

        funcionarioServico.setFuncionarioServicoId(0);
        funcionarioServico.setFuncionarioId(1);

        funcionarioServico = funcionarioServicoRepository.save(funcionarioServico);
        servico.setFuncionarioServico(funcionarioServico);
        servicoRepository.save(servico);
        /* HorarioBloqueado */

        HorarioBloqueadoEntity horarioBloqueado = new HorarioBloqueadoEntity();

        horarioBloqueado.setDia_semana_id(1);
        horarioBloqueado.setFuncionario_id(1);
        LocalTime horarioBloqInicio = LocalTime.parse("12:00:00", formatter);
        horarioBloqueado.setHorario_inicio(horarioBloqInicio);
        LocalTime horarioBloqFinal = LocalTime.parse("13:00:00", formatter);
        horarioBloqueado.setHorario_final(horarioBloqFinal);
        horarioBloqueado.setHorarioBloqueadoId(0);

        horarioBloqueadoRepository.save(horarioBloqueado);

        /* Menu */

        MenuEntity menu = new MenuEntity();

        menu.setMenuId(0);
        menu.setNome("Teste");

        menuRepository.save(menu);

        /* Agendamento */

        AgendamentoEntity agendamento = new AgendamentoEntity();

        agendamento.setAtivo(true);
        agendamento.setClienteId(1);
        try {
            java.util.Date agendaData = dateFormat.parse("11-10-2002");
            agendamento.setData(new java.sql.Date(agendaData.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        agendamento.setEmpresaId(1);
        agendamento.setFuncionarioId(1);
        LocalTime agendaHora = LocalTime.parse("15:00:00", formatter);
        agendamento.setHorario(agendaHora);
        agendamento.setAgendamentoId(0);

        agendamento = agendamentoRepository.save(agendamento);
        servico.setAgendamento(agendamento);
        servicoRepository.save(servico);
    }

    @Override
    public void run(String... args) throws Exception {

        inserirRegistros();

    }

}
