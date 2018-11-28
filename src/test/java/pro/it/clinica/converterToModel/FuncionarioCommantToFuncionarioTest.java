package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Funcionario;

import java.time.LocalDate;

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
        FuncionarioCommand funcionarioCommand = new FuncionarioCommand();
        funcionarioCommand.setNome("Esaldino");
        funcionarioCommand.setDataNascimento(LocalDate.of(1995,10,12));
        funcionarioCommand.setId(20L);
        funcionarioCommand.getNumeroTelefone().add("9340032423");
        funcionarioCommand.getEmail().add("esaldinofonseca@gmail.com");
        EnderecoCommand enderecoCommand = new EnderecoCommand();
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();

        funcionarioCommand.setEndereco(enderecoCommand );
        funcionarioCommand.getNacionalidades().add(nacionalidadeCommand);

        Funcionario funcionario = funcionarioCommantToFuncionario.convert(funcionarioCommand);
        Assert.assertEquals(funcionario.getId(),funcionarioCommand.getId());
        Assert.assertTrue(funcionario.getNumTelefone().size()>0);
        Assert.assertTrue(funcionario.getEmail().size()>0);
        Assert.assertNotNull(funcionario.getEndereco());

        //  Assert.assertNotNull();
    }
}
