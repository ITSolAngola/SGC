package pro.it.clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.bootstrap.EstadoConsulta;
import pro.it.clinica.converterToCommand.ConsultaToConsultaCommand;
import pro.it.clinica.converterToCommand.EspecialidadeToEspecialidadeCommand;
import pro.it.clinica.converterToModel.ConsultaCommandToConsulta;
import pro.it.clinica.converterToModel.EspecialidadeCommandToEspecialidade;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.repository.ConsultaRepositorio;
import pro.it.clinica.serviceImpl.ConsultaServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ConsultaServiceTest {

    @Mock
    private ConsultaRepositorio consultaRepositorio;

    private ConsultaServiceImpl consultaService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        consultaService = new ConsultaServiceImpl(consultaRepositorio,
                                            new ConsultaCommandToConsulta(new EspecialidadeCommandToEspecialidade()),
                                            new ConsultaToConsultaCommand(new EspecialidadeToEspecialidadeCommand()));
    }

    @Test
    public void novoTest(){
        ConsultaCommand consultaCommand = new ConsultaCommand();
        consultaCommand.setId(1L);
        consultaCommand.setEstado(EstadoConsulta.FAZER);
        Consulta consulta  = new Consulta();
        consulta.setEstado(EstadoConsulta.FAZER);
        consulta.setId(consultaCommand.getId());

        when(consultaRepositorio.save(any(Consulta.class))).thenReturn(consulta);

        ConsultaCommand consultaNova  =consultaService.novo(consultaCommand);
        Assert.assertEquals(consultaNova.getEstado(),EstadoConsulta.FAZER);
    }
}
