package br.com.agenda.agenda.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.agenda.agenda.entities.UsuarioEntity;
import br.com.agenda.agenda.repositories.UsuarioRepository;

@Component
public class InitDB  implements CommandLineRunner{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void inserirRegistros(){
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

    }

    @Override
    public void run(String... args) throws Exception {
        
        inserirRegistros();

    }
    
}
