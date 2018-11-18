package pro.it.gestao_clinica.bootstrap;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.model.Autorizacao;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;

import javax.transaction.Transactional;

@Slf4j
@Component
public class Inicializador implements CommandLineRunner {


    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Autorizacao autorizacao1 =  new Autorizacao("ROLE_ADMIN");
        Autorizacao autorizacao2 = new Autorizacao("ROLE_PACIENTE");
        Autorizacao autorizacao3 = new Autorizacao("ROLE_MEDICO");
        Autorizacao autorizacao4 = new Autorizacao("ROLE_USER");


        Usuario usuario = new Usuario();
        usuario.setNome("Esaldino");
        usuario.setSenha("uma123");
        usuario.setEstado(true);
        usuario.addPapeis(autorizacao1).addPapeis(autorizacao3);

        Usuario usuario1 = new Usuario();
        usuario1.setNome("itl-sol");
        usuario1.setSenha("pro-it");
        usuario1.setEstado(true);
        usuario1.addPapeis(autorizacao4).addPapeis(autorizacao2);

        usuarioRepositorio.save(usuario);
        usuarioRepositorio.save(usuario1);
        log.info("Usuarios criados");

    }
}
