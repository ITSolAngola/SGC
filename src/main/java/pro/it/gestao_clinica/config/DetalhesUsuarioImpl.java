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

import java.util.Collections;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioCommand usuarioCommand = usuarioToUsuarioCommand.convert(
                usuarioRepositorio.findByNome(username).get());
        if( usuarioCommand == null )
            throw new UsernameNotFoundException("Usuario foi encontrado");

        User user = new User(usuarioCommand.getNome(),usuarioCommand.getSenha(),usuarioCommand.getEstado(),true,true,true,usuarioCommand.getAutorizacoes());
        log.info("autenticando");
        return user;
    }
}
