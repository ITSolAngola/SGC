package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.converterToCommand.*;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.Nacionalidade;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MedicoToMedicoCommandTest {

    private FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;
    private EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand;
    private ConsultaToConsultaCommand consultaToConsultaCommand;
    private MedicoToMedicoCommand medicoToMedicoCommand;

    @Before
    public void init(){
        funcionarioToFuncionarioCommand = new FuncionarioToFuncionarioCommand(
                new EnderecoToEnderecoCommand(),
                new NacionalidadeToNacionalidadeCommand()
        );

        especialidadeToEspecialidadeCommand = new EspecialidadeToEspecialidadeCommand();
        medicoToMedicoCommand = new MedicoToMedicoCommand(
                    funcionarioToFuncionarioCommand,
                    especialidadeToEspecialidadeCommand, consultaToConsultaCommand);
    }

    @Test
    public void converterTest(){
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("Esaldino");

        Especialidade especialidade = new Especialidade();
        Especialidade especialidade1 = new Especialidade();


        funcionario.setNacionalidades( Arrays
                                        .asList( new Nacionalidade(),new Nacionalidade())
                                        .stream().collect(Collectors.toSet()));

        MedicoCommand medicoCommand = medicoToMedicoCommand.convert(funcionario);

        Assert.assertNotNull(medicoCommand);
      //  Assert.assertEquals(medicoCommand.getEspecialidades().size(),funcionario.getMedicoEspecialidades().size());
        Assert.assertEquals(medicoCommand.getNacionalidades().size(),funcionario.getNacionalidades().size());
        Assert.assertTrue(medicoCommand.getEspecialidades().size()>0);
        Assert.assertTrue(medicoCommand.getNacionalidades().size()>0);



    }
}
