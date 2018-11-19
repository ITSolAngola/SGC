package pro.it.gestao_clinica.controller;

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
import pro.it.gestao_clinica.Command.ContactoCommand;
import pro.it.gestao_clinica.Command.EnderecoCommand;
import pro.it.gestao_clinica.Command.NacionalidadeCommand;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.model.Paciente;
import pro.it.gestao_clinica.repository.PacienteRepositorio;
import pro.it.gestao_clinica.service.ServicePaciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void cadastrarTest() throws Exception{

        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(1L);
        pacienteCommand.setNome("Esaldino");
        pacienteCommand.setSobreNome("Fonseca");
        pacienteCommand.setDataNAscimento(LocalDate.of(2018,12,9));
        pacienteCommand.setPeso(4.9);
        pacienteCommand.setEstadoCivil("Solteiro");
        pacienteCommand.setGenero("Masculino");

        JSONObject paciente = new JSONObject();
        paciente.put("nome",pacienteCommand.getNome())
                .put("id",pacienteCommand.getId())
                .put("sobreNome",pacienteCommand.getSobreNome())
                .put("dataNAscimento",pacienteCommand.getDataNAscimento().toString())
                .put("peso",pacienteCommand.getPeso())
                .put("genero",pacienteCommand.getGenero())
                .put("estadoCivil",pacienteCommand.getEstadoCivil());

        EnderecoCommand enderecoCommand = new EnderecoCommand();
        enderecoCommand.setPais("Angola");
        enderecoCommand.setMunicipio("Viana");
        enderecoCommand.setCidade("Viana");
        enderecoCommand.setBairro("Vila nova");
        enderecoCommand.setNumeroCasa("35");
        enderecoCommand.setRua("Motorista");

        ContactoCommand contactoCommand = new ContactoCommand();
        contactoCommand.setEmail("esaldino");
        contactoCommand.setNumeroTelefone("943553169");
        contactoCommand.setId(1L);

        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setId(1L);
        nacionalidadeCommand.setPais("Angola");

        JSONObject nacionalidadeJson = new JSONObject();
        nacionalidadeJson.put("id",nacionalidadeCommand.getId())
                        .put("pais",nacionalidadeCommand.getPais());

        pacienteCommand.getContactos().add(contactoCommand);
        JSONObject contactoJSON = new JSONObject().put("email",contactoCommand.getEmail())
                .put("id","1")
                .put("numetoTelefone",contactoCommand.getNumeroTelefone());

        pacienteCommand.setEndereco(enderecoCommand);

        JSONObject endereco = new JSONObject();
        endereco.put("pais",enderecoCommand.getPais())
                .put("municipio",enderecoCommand.getMunicipio())
                .put("cidade",enderecoCommand.getCidade())
                .put("bairro",enderecoCommand.getBairro())
                .put("rua",enderecoCommand.getRua())
                .put("nCasa",enderecoCommand.getNumeroCasa());

        paciente.put("endereco",endereco);
        paciente.put("contactos",Collections.singletonList(contactoJSON));
        paciente.put("nacionalidades",Collections.singletonList(nacionalidadeJson));


        System.out.println(paciente.toString());

        when(servicePaciente.adicionar(Mockito.any(PacienteCommand.class))).thenReturn(pacienteCommand);

        MockHttpServletRequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/clinica/paciente/add")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(paciente.toString());

        MvcResult mock = mockMvc.perform(requestBuilder)
                .andExpect(status().isCreated())
                .andReturn();

        System.out.println(mock.getResponse().getContentAsString());

    }
}
