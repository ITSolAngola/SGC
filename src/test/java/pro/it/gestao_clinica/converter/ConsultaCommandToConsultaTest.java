package pro.it.gestao_clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.gestao_clinica.Command.ConsultaCommand;
import pro.it.gestao_clinica.model.Consulta;

import java.time.LocalDateTime;

public class ConsultaCommandToConsultaTest  {

    private ConsultaCommandToConsulta consultaCommandToConsulta;

    @Before
    public void init(){
        consultaCommandToConsulta = new ConsultaCommandToConsulta();
    }

    @Test
    public void converterTest(){
        ConsultaCommand cm = new ConsultaCommand();
        cm.setId(1L);
        cm.setDataActual(LocalDateTime.now());
        Consulta consulta = consultaCommandToConsulta.convert(cm);

        Assert.assertNotNull(consulta);
        Assert.assertNotNull(consulta.getDataMarcada());
    }
}
