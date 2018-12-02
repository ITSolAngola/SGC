package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.bootstrap.EstadoConsulta;
import pro.it.clinica.converterToCommand.*;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.Nacionalidade;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MedicoToMedicoCommandTest {

    private MedicoToMedicoCommand medicoToMedicoCommand;

    @Before
    public void init(){
        medicoToMedicoCommand = new MedicoToMedicoCommand(
                new EnderecoToEnderecoCommand(),
                new EspecialidadeToEspecialidadeCommand(),
                new ConsultaToConsultaCommand(new EspecialidadeToEspecialidadeCommand()),
                new NacionalidadeToNacionalidadeCommand()
            );
    }

    @Test
    public void converterTest(){
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("Esaldino");

        Especialidade especialidade = new Especialidade();
        Especialidade especialidade1 = new Especialidade();

        Consulta consulta = new Consulta();
        consulta.setId(1L);
     //   consulta.setEstado(EstadoConsulta.FAZER);
        consulta.setDescricao("");

        funcionario.addConsulta(consulta);
        funcionario.getEspecialidades().add(especialidade);
        funcionario.getEspecialidades().add(especialidade1);
        funcionario.setNacionalidades( Arrays
                                        .asList( new Nacionalidade(),new Nacionalidade() )
                                        .stream().collect(Collectors.toSet()));

        MedicoCommand medicoCommand = medicoToMedicoCommand.convert(funcionario);

        Assert.assertNotNull(medicoCommand);
        Assert.assertEquals(medicoCommand.getNacionalidades().size(),funcionario.getNacionalidades().size());
        Assert.assertTrue(medicoCommand.getEspecialidades().size()>0);
        Assert.assertTrue(medicoCommand.getNacionalidades().size()>0);
        Assert.assertTrue(medicoCommand.getConsultas().size()>0);

    }

}
