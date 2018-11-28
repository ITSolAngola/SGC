package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.model.Consulta;

import java.time.LocalDateTime;

public class ConsultaCommandToConsultaTest  {

    private EnderecoCommantToEnderecoTest.ConsultaCommandToConsulta consultaCommandToConsulta;

    @Before
    public void init(){
        consultaCommandToConsulta = new EnderecoCommantToEnderecoTest.ConsultaCommandToConsulta();
    }

    @Test
    public void converterTest(){
        ConsultaCommand cm = new ConsultaCommand();
        cm.setId(1L);
        cm.setData(LocalDateTime.now());
        Consulta consulta = consultaCommandToConsulta.convert(cm);

        Assert.assertNotNull(consulta);
        Assert.assertNotNull(consulta.getDataConsulta());
    }
}
