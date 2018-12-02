package pro.it.clinica.controller;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.clinica.Command.ContactoCommand;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.model.Paciente;
import pro.it.clinica.model.padrao.Endereco;
import pro.it.clinica.service.ServicePaciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PacienteControllerTest  {

    @InjectMocks
    private PacienteController pacienteController;

    @Mock
    private ServicePaciente servicePaciente;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pacienteController).build();
    }

    @Test
    public void listarTest() throws Exception{

        PacienteCommand paciente = new PacienteCommand();
        paciente.setId(1L);

        PacienteCommand paciente1 = new PacienteCommand();
        paciente1.setId(2L);

        List<PacienteCommand> lista = new ArrayList<>();
        lista.add(paciente);
        lista.add(paciente1);

        when(servicePaciente.listar()).thenReturn(lista);

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/clinica/paciente/ver");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());

    }

    public  PacienteCommand getPaciente(){
        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(1L);
        pacienteCommand.setNome("Esaldino");
        pacienteCommand.setSobreNome("Fonseca");
        pacienteCommand.setDataNascimento(LocalDate.of(2018,12,9));
        pacienteCommand.setPeso(4.9);
        pacienteCommand.setEstadoCivil("Solteiro");
        pacienteCommand.setGenero("Masculino");

        EnderecoCommand enderecoCommand = new EnderecoCommand();
        enderecoCommand.setPais("Angola");
        enderecoCommand.setMunicipio("Viana");
        enderecoCommand.setCidade("Viana");
        enderecoCommand.setBairro("Vila nova");
        enderecoCommand.setNumeroCasa("35");
        enderecoCommand.setRua("Motorista");

        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setId(1L);
        nacionalidadeCommand.setPais("Angola");

        pacienteCommand.getNumeroTelefone().add("16515615");
        pacienteCommand.getEmail().add("fgdgdfgdf");
        pacienteCommand.getNacionalidades().add(nacionalidadeCommand);
        pacienteCommand.setEndereco(enderecoCommand);

        return  pacienteCommand;
    }

    public JSONObject getJsonPaciente(PacienteCommand pacienteCommand){

        JSONObject paciente = new JSONObject();
        paciente.put("nome",pacienteCommand.getNome())
                .put("id",pacienteCommand.getId())
                .put("sobreNome",pacienteCommand.getSobreNome())
                .put("dataNascimento",pacienteCommand.getDataNascimento().toString())
                .put("peso",pacienteCommand.getPeso())
                .put("genero",pacienteCommand.getGenero())
                .put("estadoCivil",pacienteCommand.getEstadoCivil());

        JSONObject nacionalidadeJson = new JSONObject();
        nacionalidadeJson.put("id",pacienteCommand.getNacionalidades().iterator().next().getId())
                .put("pais",pacienteCommand.getNacionalidades().iterator().next().getPais());

        JSONObject endereco = new JSONObject();
        EnderecoCommand enderecoCommand = new EnderecoCommand();
        endereco.put("pais",enderecoCommand.getPais())
                .put("municipio",enderecoCommand.getMunicipio())
                .put("cidade",enderecoCommand.getCidade())
                .put("bairro",enderecoCommand.getBairro())
                .put("rua",enderecoCommand.getRua())
                .put("nCasa",enderecoCommand.getNumeroCasa());

        paciente.put("endereco",endereco);
        paciente.put("nacionalidades",Collections.singletonList(nacionalidadeJson));
        return  paciente;
    }

    @Test
    public void cadastrarTest() throws Exception{
        PacienteCommand pacienteCommand = getPaciente();
        JSONObject jsonObject = getJsonPaciente(pacienteCommand);
        when(servicePaciente.novo(Mockito.any(PacienteCommand.class))).thenReturn(pacienteCommand);

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/clinica/paciente/add")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject.toString());

        MvcResult mock = mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andReturn();

        verify(servicePaciente,Mockito.times(1)).novo(any(PacienteCommand.class));

        System.out.println(mock.getResponse().getContentAsString());

    }

    @Test
    public void editarTest() throws Exception{

        PacienteCommand pacienteCommand = getPaciente();
        JSONObject jsonObject = getJsonPaciente(pacienteCommand);

        when(servicePaciente.pesquisarId(Mockito.anyLong())).thenReturn(pacienteCommand);
        when(servicePaciente.novo(Mockito.any(PacienteCommand.class))).thenReturn(pacienteCommand);

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.put("/clinica/paciente/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonObject.toString());

        MvcResult mock = mockMvc.perform(requestBuilder)
                .andExpect(status().isAccepted())
                .andReturn();

        verify(servicePaciente,Mockito.times(1)).novo(any(PacienteCommand.class));

        System.out.println(mock.getResponse().getContentAsString());

    }
}
