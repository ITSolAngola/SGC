package pro.it.clinica.controller;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.bootstrap.EstadoConsulta;
import pro.it.clinica.converterToModel.ConsultaCommandToConsulta;
import pro.it.clinica.converterToModel.EspecialidadeCommandToEspecialidade;
import pro.it.clinica.service.ServiceConsulta;
import pro.it.clinica.service.ServiceMedico;
import pro.it.clinica.service.ServicePaciente;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ConsultaControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private ConsultaController consultaController;
    @Mock
    private ServiceConsulta serviceConsulta;
    @Mock
    private ServiceMedico serviceMedico;
    @Mock
    private ServicePaciente servicePaciente;

    private ConsultaCommandToConsulta consultaCommandToConsulta;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        consultaCommandToConsulta = new ConsultaCommandToConsulta(new EspecialidadeCommandToEspecialidade());
        mockMvc = MockMvcBuilders.standaloneSetup(consultaController).build();
    }

    @Test
    public void cadastroTest() throws Exception{
        ConsultaCommand consultaCommand = new ConsultaCommand();
        consultaCommand.setId(1L);
        consultaCommand.setEstado(EstadoConsulta.FAZER);
        consultaCommand.setDataConsulta(LocalDateTime.now());
        consultaCommand.setDataHoje(LocalDateTime.now());

        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand(1L,"Gene",200D);
        consultaCommand.setEspecialidadeCommand( especialidadeCommand );

        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setId(2L);
        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(3L);

        when(serviceMedico.pesquisarId(anyLong())).thenReturn(medicoCommand);
        when(servicePaciente.pesquisarId(anyLong())).thenReturn(pacienteCommand);
        when(serviceMedico.novo(any(MedicoCommand.class))).thenReturn(new MedicoCommand());
        when(servicePaciente.novo(any(PacienteCommand.class))).thenReturn(new PacienteCommand());
        when(serviceConsulta.novo(any(ConsultaCommand.class))).thenReturn(consultaCommand);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("id",especialidadeCommand.getId());
        jsonObject1.put("nome",especialidadeCommand.getNome());
        jsonObject1.put("preco",especialidadeCommand.getPreco());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",consultaCommand.getId());
        jsonObject.put("estado",EstadoConsulta.FAZER.toString());
        jsonObject.put("dataConsulta",consultaCommand.getDataConsulta());
        jsonObject.put("dataHoje",consultaCommand.getDataHoje());
        jsonObject.put("especialidadeCommand",jsonObject1);

        System.out.println(jsonObject.toString());

        mockMvc.perform(post("/clinica/consulta/medico/2/paciente/3")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(jsonObject.toString()))
                  .andExpect(status().isOk());

    }
}
