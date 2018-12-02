package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.bootstrap.EstadoConsulta;
import pro.it.clinica.model.Consulta;

import java.time.LocalDateTime;

public class ConsultaCommandToConsultaTest  {

    private ConsultaCommandToConsulta consultaCommandToConsulta;

    @Before
    public void init(){

        consultaCommandToConsulta = new ConsultaCommandToConsulta(new EspecialidadeCommandToEspecialidade());
    }

    @Test
    public void converterTest(){
        ConsultaCommand cm = new ConsultaCommand();
        cm.setId(1L);
        cm.setDataHoje(LocalDateTime.now());
        cm.setDataConsulta(LocalDateTime.now());
        cm.setDescricao("");
        cm.setEstado(EstadoConsulta.FAZER);
        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand();
        especialidadeCommand.setId(1L);
        especialidadeCommand.setNome("Endocrinologia");
        cm.setEspecialidadeCommand(especialidadeCommand);

        Consulta consulta = consultaCommandToConsulta.convert(cm);

        Assert.assertNotNull(consulta);
        Assert.assertNotNull(consulta.getDataConsulta());
        Assert.assertEquals(consulta.getEstado(),EstadoConsulta.FAZER);
        Assert.assertEquals(consulta.getEspecialidade().getNome(),especialidadeCommand.getNome());
    }

}
