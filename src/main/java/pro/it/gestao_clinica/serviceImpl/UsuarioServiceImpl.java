package pro.it.gestao_clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.converter.UsuarioToUsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;
import pro.it.gestao_clinica.service.ServiceUsuario;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements ServiceUsuario {

    private UsuarioRepositorio usuarioRepositorio;
    private UsuarioToUsuarioCommand usuarioToUsuarioCommand;

    public UsuarioServiceImpl(UsuarioRepositorio usuarioRepositorio, UsuarioToUsuarioCommand usuarioToUsuarioCommand) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.usuarioToUsuarioCommand = usuarioToUsuarioCommand;
    }

    @Override
    public UsuarioCommand confirmacao(UsuarioCommand usuario) {

        Optional<Usuario> usuarioOptional = usuarioRepositorio.findByNomeAndSenha(usuario.getNome(),usuario.getSenha());
        UsuarioCommand usuarioCommand = usuarioToUsuarioCommand.convert(usuarioOptional.get());
        return usuarioCommand;

    }



}