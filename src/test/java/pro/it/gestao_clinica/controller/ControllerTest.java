package pro.it.gestao_clinica.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.converter.AutorizacaoToAutorizacaoCommand;
import pro.it.gestao_clinica.converter.UsuarioToUsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;
import pro.it.gestao_clinica.service.ServiceUsuario;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControllerTest {

        @Mock
        private UsuarioRepositorio usuarioRepositorio;

        @Mock
        private ServiceUsuario usuarioService;

        private UsuarioToUsuarioCommand usuarioToUsuarioCommand;

        private MockMvc mockMvc;

        @InjectMocks
        private InitController controller;

    private AutorizacaoToAutorizacaoCommand autorizacaoToAutorizacaoCommand;

        @Before
        public void setup() {
            MockitoAnnotations.initMocks(this);
            autorizacaoToAutorizacaoCommand = new AutorizacaoToAutorizacaoCommand();
            usuarioToUsuarioCommand = new UsuarioToUsuarioCommand(autorizacaoToAutorizacaoCommand);
            mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        }

        @Test
        public void indexTest() throws Exception{

            Usuario usuario = new Usuario();
            usuario.setNome("pro-it");
            usuario.setSenha("uma124");
            usuario.setEstado(true);
            Optional<Usuario> usuario1 = Optional.of(usuario);

            Mockito.when(usuarioRepositorio.findByNome(Mockito.anyString()))
                        .thenReturn(usuario1);

            UsuarioCommand usuarioCommand = usuarioToUsuarioCommand.convert(usuario);

            String json = "{\"nome\":\""+usuarioCommand.getNome()+"\","+
                            "\"senha\":\""+usuarioCommand.getSenha()+ "\","+
                            "\"estado\":\""+usuarioCommand.getEstado()+"\"}";
            System.out.println(json);

            MockHttpServletResponse result =  mockMvc.perform(post("/clinica/login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(  json) )
                            .andExpect(status().isOk()).andReturn().getResponse();

            Assert.assertNotNull(result.getContentAsString());

        }

        @Test
        public void helloTest() throws Exception {
            mockMvc.perform(get(("/clinica")))
                    .andExpect(status().isOk());
        }


}
