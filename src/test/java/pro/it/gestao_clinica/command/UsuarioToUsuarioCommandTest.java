package pro.it.gestao_clinica.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.converter.UsuarioToUsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;

public class UsuarioToUsuarioCommandTest {

    private UsuarioToUsuarioCommand usuarioToUsuarioCommand;

    @Before
    public void init(){
        usuarioToUsuarioCommand = new UsuarioToUsuarioCommand();
    }

    @Test
    public void convertTest(){
        Usuario usuario = new Usuario();
        usuario.setNome("pro-it");
        usuario.setSenha("uma124");
        usuario.setEstado(true);

        UsuarioCommand usuarioCommand = usuarioToUsuarioCommand.convert(usuario);

        Assert.assertNotNull(usuarioCommand);
        Assert.assertEquals(usuarioCommand.getNome(), usuario.getNome());
    }

}
