package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.bootstrap.EstadoConsulta;
import pro.it.clinica.converterToCommand.ConsultaToConsultaCommand;
import pro.it.clinica.converterToCommand.EspecialidadeToEspecialidadeCommand;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.model.Desconto;
import pro.it.clinica.model.Especialidade;

import java.time.LocalDateTime;

public class ConsultaToConsultaCommandTest {

    private ConsultaToConsultaCommand consultaToConsultaCommand;

    @Before
    public void init(){
        consultaToConsultaCommand = new ConsultaToConsultaCommand(new EspecialidadeToEspecialidadeCommand());
    }

    @Test
    public void converterTest(){
        Consulta consulta = new Consulta();
        consulta.setEstado(EstadoConsulta.FAZER);
        consulta.setId(20L);
        consulta.setDataActual(LocalDateTime.now());
        consulta.setDataConsulta(LocalDateTime.now());
        consulta.setEspecialidade(new Especialidade());

        ConsultaCommand consultaCommand = consultaToConsultaCommand.convert(consulta);
        Assert.assertEquals(consultaCommand.getEstado(),EstadoConsulta.FAZER);
        Assert.assertNotNull(consulta.getEspecialidade());


    }
}
