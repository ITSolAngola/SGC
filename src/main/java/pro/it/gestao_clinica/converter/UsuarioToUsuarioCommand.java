package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;

import java.util.stream.Collectors;

@Component
public class UsuarioToUsuarioCommand implements Converter<Usuario,UsuarioCommand> {

    private AutorizacaoToAutorizacaoCommand autorizacaoToAutorizacaoCommand;

    public UsuarioToUsuarioCommand(AutorizacaoToAutorizacaoCommand autorizacaoToAutorizacaoCommand) {
        this.autorizacaoToAutorizacaoCommand = autorizacaoToAutorizacaoCommand;
    }

    @Override
    public UsuarioCommand convert(Usuario usuario) {
        UsuarioCommand usuarioCommand = new UsuarioCommand();
        usuarioCommand.setNome( usuario.getNome());
        usuarioCommand.setEstado(usuario.getEstado());
        usuarioCommand.setSenha(usuario.getSenha());
        usuarioCommand.setAutorizacoes( usuario.getAutorizacaos().stream()
                                    .map(autorizacaoToAutorizacaoCommand::convert)
                                    .collect(Collectors.toSet()));
        return usuarioCommand;
    }

}
