package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.converterToCommand.EnderecoToEnderecoCommand;
import pro.it.clinica.converterToCommand.FuncionarioToFuncionarioCommand;
import pro.it.clinica.converterToCommand.NacionalidadeToNacionalidadeCommand;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.Nacionalidade;
import pro.it.clinica.model.padrao.Endereco;

import java.time.LocalDate;

public class FuncionarioToFuncionarioCommandTest {
    private EnderecoToEnderecoCommand enderecoToEnderecoCommand;
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;
    private FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;

    @Before
    public void init(){
        enderecoToEnderecoCommand = new EnderecoToEnderecoCommand();
        nacionalidadeToNacionalidadeCommand = new NacionalidadeToNacionalidadeCommand();
        funcionarioToFuncionarioCommand = new FuncionarioToFuncionarioCommand(enderecoToEnderecoCommand,
                nacionalidadeToNacionalidadeCommand);
    }

    @Test
    public void convertTest(){
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("Esaldino");
        funcionario1.setDataNAscimento(LocalDate.of(1995,10,12));
        funcionario1.setId(20L);
        funcionario1.getNumTelefone().add("9340032423");
        funcionario1.getEmail().add("esaldinofonseca@gmail.com");
        Endereco endereco = new Endereco();
        Nacionalidade nacionalidade = new Nacionalidade();

        funcionario1.setEndereco(endereco );
        funcionario1.getNacionalidades().add(nacionalidade);

        FuncionarioCommand funcionarioCommand = funcionarioToFuncionarioCommand.convert(funcionario1);
        Assert.assertEquals(funcionarioCommand.getId(),funcionario1.getId());
        Assert.assertTrue(funcionarioCommand.getNumeroTelefone().size()>0);
        Assert.assertTrue(funcionarioCommand.getEmail().size()>0);
        Assert.assertNotNull(funcionarioCommand.getEndereco());

        //  Assert.assertNotNull();
    }
}
