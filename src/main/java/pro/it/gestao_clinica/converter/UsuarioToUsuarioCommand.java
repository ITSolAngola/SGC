package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;

@Component
public class UsuarioToUsuarioCommand implements Converter<Usuario,UsuarioCommand> {

    @Override
    public UsuarioCommand convert(Usuario usuario) {
        UsuarioCommand usuarioCommand = new UsuarioCommand();
        usuarioCommand.setNome( usuario.getNome());
        usuarioCommand.setEstado(usuario.getEstado());
        usuarioCommand.setSenha(usuario.getSenha());
        return usuarioCommand;
    }

}
