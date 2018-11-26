package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.MedicoEspecialidade;
import pro.it.clinica.model.Nacionalidade;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MedicoToMedicoCommandTest {

    private FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;
    private EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand;
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
                    especialidadeToEspecialidadeCommand);
    }

    @Test
    public void converterTest(){
        Funcionario funcionario = new Funcionario();
        funcionario.setId(1L);
        funcionario.setNome("Esaldino");

        Especialidade especialidade = new Especialidade();
        Especialidade especialidade1 = new Especialidade();

        MedicoEspecialidade medicoEspecialidade = new MedicoEspecialidade(funcionario,especialidade);
        MedicoEspecialidade especialidade2 = new MedicoEspecialidade(funcionario,especialidade1);

        funcionario.getMedicoEspecialidades().add(medicoEspecialidade);
        funcionario.getMedicoEspecialidades().add(especialidade2);

        funcionario.setNacionalidades( Arrays
                                        .asList( new Nacionalidade(),new Nacionalidade())
                                        .stream().collect(Collectors.toSet()));

        MedicoCommand medicoCommand = medicoToMedicoCommand.convert(funcionario);

        Assert.assertNotNull(medicoCommand);
        Assert.assertEquals(medicoCommand.getEspecialidades().size(),funcionario.getMedicoEspecialidades().size());
        Assert.assertEquals(medicoCommand.getNacionalidades().size(),funcionario.getNacionalidades().size());
        Assert.assertTrue(medicoCommand.getEspecialidades().size()>0);
        Assert.assertTrue(medicoCommand.getNacionalidades().size()>0);



    }
}
