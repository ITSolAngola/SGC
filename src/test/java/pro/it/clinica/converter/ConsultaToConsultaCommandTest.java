package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.model.Desconto;

import java.time.LocalDateTime;

public class ConsultaToConsultaCommandTest {

    private ConsultaToConsultaCommand consultaToConsultaCommand;

    @Before
    public void init(){
        consultaToConsultaCommand = new ConsultaToConsultaCommand();
    }

    @Test
    public void converterTest(){
        Consulta consulta = new Consulta();
        consulta.setEstado(false);
        consulta.setId(20L);
        consulta.setDataMarcada(LocalDateTime.now());
        consulta.setDataConsulta(LocalDateTime.now());
        Desconto desconto = new Desconto(10,"BONUS",1000D);

        ConsultaCommand consultaCommand = consultaToConsultaCommand.convert(consulta);
        Assert.assertFalse(consultaCommand.getEstado());


    }
}
