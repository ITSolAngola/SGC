package pro.it.clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.converterToCommand.EnderecoToEnderecoCommand;
import pro.it.clinica.converterToCommand.FuncionarioToFuncionarioCommand;
import pro.it.clinica.converterToCommand.NacionalidadeToNacionalidadeCommand;
import pro.it.clinica.converterToModel.*;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.repository.FuncionarioRepositorio;
import pro.it.clinica.serviceImpl.FuncionarioServiceImpl;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class FuncionarioServiceImplTest  {


    @Mock
    private FuncionarioRepositorio funcionarioRepositorio;

    private EnderecoToEnderecoCommand enderecoToEnderecoCommand;
    private EnderecoCommandToEndereco enderecoCommandToEndereco;
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    private FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;
    private FuncionarioCommantToFuncionario funcionarioCommantToFuncionario;
    private FuncionarioServiceImpl funcionarioService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        enderecoCommandToEndereco = new EnderecoCommandToEndereco();
        enderecoToEnderecoCommand = new EnderecoToEnderecoCommand();
        nacionalidadeCommandToNacionalidade = new NacionalidadeCommandToNacionalidade();
        nacionalidadeToNacionalidadeCommand = new NacionalidadeToNacionalidadeCommand();


        funcionarioToFuncionarioCommand = new FuncionarioToFuncionarioCommand(enderecoToEnderecoCommand,nacionalidadeToNacionalidadeCommand);
        funcionarioCommantToFuncionario = new FuncionarioCommantToFuncionario(enderecoCommandToEndereco,nacionalidadeCommandToNacionalidade);
        funcionarioService = new FuncionarioServiceImpl(funcionarioRepositorio,
                funcionarioCommantToFuncionario,
                funcionarioToFuncionarioCommand);
    }

    public FuncionarioCommand get(){
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
        return funcionarioCommand;
    }

    @Test
    public void novoTest(){
        FuncionarioCommand funcionarioCommand = get();
        Funcionario funcionario = funcionarioCommantToFuncionario.convert(funcionarioCommand);

        when(funcionarioRepositorio.save(any(Funcionario.class))).thenReturn(funcionario);

        FuncionarioCommand novo = funcionarioService.novo(funcionarioCommand);

        Assert.assertNotNull(novo);
        Assert.assertEquals(funcionario.getId(),novo.getId());
    }
}
