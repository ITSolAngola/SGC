package pro.it.gestao_clinica.controller;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class InitControllerTest {

        @Mock
        private UsuarioRepositorio usuarioRepositorio;

        private MockMvc mockMvc;

        @InjectMocks
        private InitController controller;


        @Before
        public void setup() {
            MockitoAnnotations.initMocks(this);
            mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        }

        @Test
        public void helloTest() throws Exception {
            mockMvc.perform(get(("/clinica")))
                    .andExpect(status().isOk());
        }


}
