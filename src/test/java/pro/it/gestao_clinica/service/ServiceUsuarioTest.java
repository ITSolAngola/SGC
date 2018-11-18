package pro.it.gestao_clinica.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.converter.AutorizacaoToAutorizacaoCommand;
import pro.it.gestao_clinica.converter.UsuarioToUsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;
import pro.it.gestao_clinica.serviceImpl.UsuarioServiceImpl;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ServiceUsuarioTest {


    private ServiceUsuario serviceUsuario;

    @Mock
    private UsuarioRepositorio usuarioRepositorio;

    private UsuarioToUsuarioCommand usuarioToUsuarioCommand;
    private AutorizacaoToAutorizacaoCommand autorizacaoToAutorizacaoCommand;

    @Before
    public void inicialidor(){
        MockitoAnnotations.initMocks(this);
        autorizacaoToAutorizacaoCommand = new AutorizacaoToAutorizacaoCommand();
        usuarioToUsuarioCommand = new UsuarioToUsuarioCommand(autorizacaoToAutorizacaoCommand);
        serviceUsuario = new UsuarioServiceImpl(usuarioRepositorio, usuarioToUsuarioCommand);
    }

    @Test
    public void confirmacaoTest(){

        Usuario usuario = new Usuario();
        usuario.setNome("pro-it");
        usuario.setSenha("uma124");
        Optional<Usuario> usuario1 = Optional.of(usuario);

        when( usuarioRepositorio.findByNome(anyString())).thenReturn(usuario1);
        UsuarioCommand usuarioCommand = usuarioToUsuarioCommand.convert(usuario);
        //UsuarioCommand usua = serviceUsuario.confirmacao(usuarioCommand);

        //Assert.assertEquals(usua.getNome(),usuario.getNome());
        //Assert.assertNotNull(usua);
    }
}
