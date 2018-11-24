package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Funcionario;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

public class FuncionarioCommantToFuncionarioTest {

    private FuncionarioCommantToFuncionario funcionarioCommantToFuncionario;
    private EnderecoCommandToEndereco enderecoCommandToEndereco;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    @Before
    public void init(){
        enderecoCommandToEndereco = new EnderecoCommandToEndereco();
        nacionalidadeCommandToNacionalidade = new NacionalidadeCommandToNacionalidade();
        funcionarioCommantToFuncionario = new FuncionarioCommantToFuncionario(enderecoCommandToEndereco,
                nacionalidadeCommandToNacionalidade);
    }

    @Test
    public void convertTest(){
        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setNome("Esaldino");
        medicoCommand.setDataNascimento(LocalDate.of(1995,10,12));
        medicoCommand.setId(20L);
        medicoCommand.getNumeroTelefone().add("9340032423");
        medicoCommand.getEmail().add("esaldinofonseca@gmail.com");
        EnderecoCommand enderecoCommand = new EnderecoCommand();
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();

        medicoCommand.setEndereco(enderecoCommand );
        medicoCommand.getNacionalidades().add(nacionalidadeCommand);

        Funcionario funcionario = funcionarioCommantToFuncionario.convert(medicoCommand);
        Assert.assertEquals(funcionario.getId(),medicoCommand.getId());
        Assert.assertTrue(funcionario.getNumTelefone().size()>0);
        Assert.assertTrue(funcionario.getEmail().size()>0);
        Assert.assertNotNull(funcionario.getEndereco());

        //  Assert.assertNotNull();
    }
}
