package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.UsuarioCommand;
import pro.it.clinica.model.Autorizacao;
import pro.it.clinica.model.Usuario;

public class UsuarioToUsuarioCommandTest {

    private UsuarioToUsuarioCommand usuarioToUsuarioCommand;
    private AutorizacaoToAutorizacaoCommand autorizacaoToAutorizacaoCommand;

    @Before
    public void init(){
        autorizacaoToAutorizacaoCommand = new AutorizacaoToAutorizacaoCommand();
        usuarioToUsuarioCommand = new UsuarioToUsuarioCommand(autorizacaoToAutorizacaoCommand);
    }

    @Test
    public void convertTest(){
        Usuario usuario = new Usuario();
        usuario.setNome("pro-it");
        usuario.setSenha("uma124");
        usuario.setEstado(true);
        Autorizacao autorizacao = new Autorizacao("ROLE_ADMIN");
        usuario.getAutorizacaos().add(autorizacao);

        UsuarioCommand usuarioCommand = usuarioToUsuarioCommand.convert(usuario);

        Assert.assertNotNull(usuarioCommand);
        Assert.assertEquals(usuarioCommand.getNome(), usuario.getNome());
        Assert.assertTrue(usuarioCommand.getAutorizacoes().size()>0);
    }

}
