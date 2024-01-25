package br.com.agenda.agenda.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.agenda.agenda.entities.ClienteEntity;
import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.ClienteRepository;
import br.com.agenda.agenda.repositories.UsuarioRepository;

@Component
public class InitDB implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public void inserirRegistros() {
        System.out.println("Inserindo registros");

        UsuarioEntity usuarioEntity1 = new UsuarioEntity();
        usuarioEntity1.setId(0);
        usuarioEntity1.setAtivo(true);
        usuarioEntity1.setBairro("Parque California");
        usuarioEntity1.setCep("12305-600");
        usuarioEntity1.setCidade("Jacareí");
        usuarioEntity1.setComplemento("Casa dos fundos");
        usuarioEntity1.setEmail("gustaluizgonc@gmail.com");
        usuarioEntity1.setLogradouro("Rua Santa Cruz");
        usuarioEntity1.setNome("Gustavo Luiz França Gonçalves");
        usuarioEntity1.setNumero("814");
        usuarioEntity1.setSenha("123456");
        usuarioEntity1.setTelefone("(12) 98139-4021");
        usuarioEntity1.setUf("SP");

        UsuarioEntity usuarioEntity2 = new UsuarioEntity();

        usuarioEntity2.setId(0);
        usuarioEntity2.setAtivo(true);
        usuarioEntity2.setBairro("Jardim California");
        usuarioEntity2.setCep("12305-150");
        usuarioEntity2.setCidade("São José dos Campos");
        usuarioEntity2.setComplemento("Condominio 315");
        usuarioEntity2.setEmail("madueff@gmail.com");
        usuarioEntity2.setLogradouro("Avenida Andromeda");
        usuarioEntity2.setNome("Maria Eduarda Faria Freitas");
        usuarioEntity2.setNumero("135");
        usuarioEntity2.setSenha("teste123");
        usuarioEntity2.setTelefone("(12) 98236-4506");
        usuarioEntity2.setUf("RJ");

        usuarioRepository.save(usuarioEntity1);
        usuarioRepository.save(usuarioEntity2);

        ClienteEntity clienteEntity1 = new ClienteEntity();

        clienteEntity1.setAtivo(true);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            java.util.Date dataNascimento = dateFormat.parse("11-10-2002");
            clienteEntity1.setData_nascimento(new java.sql.Date(dataNascimento.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
            
        }
        clienteEntity1.setDescricao("Tenho 18 anos");
        clienteEntity1.setEmail("cliente@gmail.com");
        clienteEntity1.setId(0);
        clienteEntity1.setNome("Cliente Teste");
        clienteEntity1.setSenha("12345678");
        clienteEntity1.setTelefone("(12) 98199-9998");

        clienteRepository.save(clienteEntity1);
    }

    @Override
    public void run(String... args) throws Exception {

        inserirRegistros();

    }

}
