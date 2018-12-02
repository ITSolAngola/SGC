package pro.it.clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pro.it.clinica.Command.*;
import pro.it.clinica.converterToCommand.*;
import pro.it.clinica.converterToModel.*;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.repository.FuncionarioRepositorio;
import pro.it.clinica.serviceImpl.MedicoServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.time.LocalDate.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MedicoServiceImplTest {

    @Mock
    private FuncionarioRepositorio funcionarioRepositorio;

    private MedicoServiceImpl medicoService;

    private MedicoCommandToMedico medicoCommandToMedico;
    private MedicoToMedicoCommand medicoToMedicoCommand;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        medicoCommandToMedico = new MedicoCommandToMedico(
                new EspecialidadeCommandToEspecialidade(),
                new FuncionarioCommantToFuncionario(
                        new EnderecoCommandToEndereco(),
                        new NacionalidadeCommandToNacionalidade()
                ),new NacionalidadeCommandToNacionalidade(),
                new ConsultaCommandToConsulta(new EspecialidadeCommandToEspecialidade()));

        medicoToMedicoCommand = new MedicoToMedicoCommand(
                new EnderecoToEnderecoCommand(),
                new EspecialidadeToEspecialidadeCommand(),
                new ConsultaToConsultaCommand(new EspecialidadeToEspecialidadeCommand()),
                new NacionalidadeToNacionalidadeCommand()
        );

        medicoService = new MedicoServiceImpl(funcionarioRepositorio,
                medicoCommandToMedico,medicoToMedicoCommand);

    }

    @Test
    public void novoTest(){
        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setId(1L);
        medicoCommand.setDataNascimento(of(2014,12,8));
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        Set<NacionalidadeCommand> nacionalidadeCommandSet = new HashSet<>();
        nacionalidadeCommandSet.add(nacionalidadeCommand);
        medicoCommand.setNacionalidades(nacionalidadeCommandSet);

        EnderecoCommand enderecoCommand = new EnderecoCommand();
        medicoCommand.setEndereco(enderecoCommand);
        Set<EspecialidadeCommand> especialidadeCommandList = Arrays.asList(
                new EspecialidadeCommand(),
                new EspecialidadeCommand(),
                new EspecialidadeCommand()
        ).stream().collect(Collectors.toSet());

        medicoCommand.setEspecialidades(especialidadeCommandList);

        ConsultaCommand consultaCommand = new ConsultaCommand();
        consultaCommand.setId(1L);
        medicoCommand.getConsultas().add(consultaCommand);

        Funcionario funcionario = medicoCommandToMedico.convert(medicoCommand);

        when(funcionarioRepositorio.save(any(Funcionario.class))).thenReturn(funcionario);

        MedicoCommand medicoCommand1 = medicoService.novo(medicoCommand);

        Assert.assertNotNull(medicoCommand1);
        Assert.assertEquals(medicoCommand1.getEspecialidades().size(),especialidadeCommandList.size());
        Assert.assertTrue(medicoCommand1.getConsultas().size()>0);
        verify(funcionarioRepositorio,Mockito.times(1)).save(any(Funcionario.class));

    }
}
