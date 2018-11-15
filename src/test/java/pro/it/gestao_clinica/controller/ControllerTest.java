package pro.it.gestao_clinica.controller;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.converter.UsuarioToUsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;
import pro.it.gestao_clinica.service.ServiceUsuario;
import pro.it.gestao_clinica.serviceImpl.UsuarioServiceImpl;

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

        private InitController controller;

        @Before
        public void setup() {
            MockitoAnnotations.initMocks(this);
            controller = new InitController(usuarioService);
            usuarioToUsuarioCommand = new UsuarioToUsuarioCommand();
            mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        }

        @Test
        public void indexTest() throws Exception{

            Usuario usuario = new Usuario();
            usuario.setNome("pro-it");
            usuario.setSenha("uma124");
            usuario.setEstado(true);
            Optional<Usuario> usuario1 = Optional.of(usuario);


            Mockito.when(usuarioRepositorio.findByNomeAndSenha(Mockito.anyString(),Mockito.anyString()))
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