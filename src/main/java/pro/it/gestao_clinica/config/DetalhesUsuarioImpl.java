package pro.it.gestao_clinica.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.converter.UsuarioToUsuarioCommand;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;

import javax.transaction.Transactional;


@Slf4j
@Service
public class DetalhesUsuarioImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    private UsuarioToUsuarioCommand usuarioToUsuarioCommand;

    public DetalhesUsuarioImpl(UsuarioToUsuarioCommand usuarioToUsuarioCommand) {
        this.usuarioToUsuarioCommand = usuarioToUsuarioCommand;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioCommand usuarioCommand = usuarioToUsuarioCommand.convert(
                usuarioRepositorio.findByNome(username).get());

        System.out.println(usuarioCommand);
        if( usuarioCommand == null )
            throw new UsernameNotFoundException("Usuario nao foi encontrado");

        log.info("autenticando");
        return usuarioCommand;
    }
}
