package pro.it.clinica.controller;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.service.ServiceEspecialidade;
import pro.it.clinica.serviceImpl.EspecialidadeServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EspecialidadeControllerTest {

    @InjectMocks
    private EspecialidadeController especialidadeController;

    @Mock
    private ServiceEspecialidade especialidadeService;

    private MockMvc mockMvc;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(especialidadeController).build();
    }


    @Test
    public void adicionarTest() throws Exception{

        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand();
        especialidadeCommand.setId(1L);
        especialidadeCommand.setPreco(20.9);
        especialidadeCommand.setNome("Genecologia");

        JSONObject jsonObjectEspecialidade = new JSONObject();
        jsonObjectEspecialidade.put("nome",especialidadeCommand.getNome())
                                .put("id",1)
                                .put("preco",2000.0);

        when(especialidadeService.novo(Mockito.any(EspecialidadeCommand.class))).thenReturn(especialidadeCommand);

        MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
                                MockMvcRequestBuilders.post("/clinica/especialidade/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonObjectEspecialidade.toString());

        mockMvc.perform(mockHttpServletRequestBuilder)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome",equalTo("Genecologia")));
    }

    @Test
    public void listarTest() throws Exception{
        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand();
        especialidadeCommand.setId(1L);
        especialidadeCommand.setPreco(20.9);
        especialidadeCommand.setNome("Genecologia");

        EspecialidadeCommand especialidadeCommand1 = new EspecialidadeCommand();
        especialidadeCommand1.setId(2L);
        especialidadeCommand1.setPreco(20.9);
        especialidadeCommand1.setNome("Genecologia");

        List<EspecialidadeCommand> lista = Arrays.asList(especialidadeCommand,
                                                        especialidadeCommand1);

        when( especialidadeService.listar()).thenReturn(lista);

        mockMvc.perform(get("/clinica/especialidade/list"))
                .andExpect(status().isOk());

    }

    @Test
    public void editarTest()
        throws Exception{
        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand();
        especialidadeCommand.setId(1L);
        especialidadeCommand.setPreco(20.9);
        especialidadeCommand.setNome("Genecologia");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",especialidadeCommand.getId())
                  .put("preco",especialidadeCommand.getPreco())
                  .put("nome",especialidadeCommand.getNome());

        when(especialidadeService.pesquisarId(anyLong())).thenReturn(especialidadeCommand);

        mockMvc.perform(put("/clinica/especialidade/edit/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonObject.toString()))
                .andExpect(status().isOk());
    }


}
