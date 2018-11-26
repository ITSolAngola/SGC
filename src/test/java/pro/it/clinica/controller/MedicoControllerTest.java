package pro.it.clinica.controller;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.omg.CORBA.Any;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.service.ServiceEspecialidade;
import pro.it.clinica.service.ServiceMedico;
import pro.it.clinica.service.ServiceNacionalidade;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MedicoControllerTest {

    @InjectMocks
    private MedicoController medicoController;

    @Mock
    private ServiceMedico serviceMedico;
    @Mock
    private ServiceNacionalidade nacionalidadeService;
    @Mock
    private ServiceEspecialidade serviceEspecialidade;

    private MockMvc mockMvc;
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc =MockMvcBuilders.standaloneSetup(medicoController).build();
    }

    @Test
    public void adicionarTest() throws Exception {

        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setId(1L);
        medicoCommand.setNome("Esaldino");
        medicoCommand.getEspecialidades()
                .add(new EspecialidadeCommand());
        medicoCommand.getEspecialidades().add(new EspecialidadeCommand());
        medicoCommand.getEspecialidades().add(new EspecialidadeCommand());

        when(serviceEspecialidade.valida(any(EspecialidadeCommand.class))).thenReturn(new EspecialidadeCommand());

        when(nacionalidadeService.validacao(any(NacionalidadeCommand.class))).thenReturn(new NacionalidadeCommand());
        when(serviceMedico.novo(any(MedicoCommand.class))).thenReturn(medicoCommand);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", medicoCommand.getId())
                .put("nome", medicoCommand.getNome())
                .put("especialidades", medicoCommand.getEspecialidades());

        mockMvc.perform(post("/clinica/medico")
                .content(jsonObject.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.especialidades", hasSize(3)));
    }

        @Test
        public void editatTEst() throws Exception{

            MedicoCommand medicoCommand = new MedicoCommand();
            medicoCommand.setId(1L);
            medicoCommand.setNome("Antonio");
            medicoCommand.getEspecialidades()
                    .add( new EspecialidadeCommand() );
            medicoCommand.getEspecialidades().add(new EspecialidadeCommand() );
            medicoCommand.getEspecialidades().add(new EspecialidadeCommand());

            MedicoCommand medicoCommand1 = new MedicoCommand();
            medicoCommand1.setId(1L);
            medicoCommand1.setNome("Esaldino");
            medicoCommand1.getEspecialidades()
                    .add( new EspecialidadeCommand() );
            medicoCommand1.getEspecialidades().add(new EspecialidadeCommand() );
            medicoCommand1.getEspecialidades().add(new EspecialidadeCommand());

            when(serviceEspecialidade.valida(any(EspecialidadeCommand.class))).thenReturn(new EspecialidadeCommand());
            when(nacionalidadeService.validacao(any(NacionalidadeCommand.class))).thenReturn(new NacionalidadeCommand());
            when(serviceMedico.pesquisarId(anyLong())).thenReturn(medicoCommand1);
            when(serviceMedico.novo(any(MedicoCommand.class))).thenReturn(medicoCommand);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",medicoCommand.getId())
                    .put("nome",medicoCommand.getNome())
                    .put("especialidades",medicoCommand.getEspecialidades());

            mockMvc.perform(put("/clinica/medico/1")
                    .content(jsonObject.toString())
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.nome",equalTo("Antonio")))
                    .andExpect(jsonPath("$.especialidades",hasSize(3)));
        }


    @Test
    public void listarTest() throws Exception{

        MedicoCommand medicoCommand1 = new MedicoCommand();
        medicoCommand1.setId(1L);
        medicoCommand1.setNome("Esaldino");
        medicoCommand1.getEspecialidades()
                .add( new EspecialidadeCommand(1L,"nome",200D) );

        medicoCommand1.getNacionalidades().add(new NacionalidadeCommand());

        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setId(1L);
        medicoCommand.setNome("Esaldino");
        medicoCommand.getEspecialidades()
                .add( new EspecialidadeCommand(1L,"nome",200D) );

        medicoCommand.getNacionalidades().add(new NacionalidadeCommand());

        List<MedicoCommand> medicoCommandList = Arrays.asList(medicoCommand,medicoCommand1);
        when( serviceMedico.listar() ).thenReturn(medicoCommandList);

        MvcResult mockMockit = mockMvc.perform( get("/clinica/medico")
                                                .contentType(MediaType.APPLICATION_JSON) )
                        .andExpect( status().isOk() )
                        .andExpect( jsonPath("$",hasSize(2)))
                        .andReturn();

        System.out.println(mockMockit.getResponse().getContentAsString());
                        //;


    }

}
