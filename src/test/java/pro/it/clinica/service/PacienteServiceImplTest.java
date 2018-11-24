package pro.it.clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.converter.*;
import pro.it.clinica.model.Nacionalidade;
import pro.it.clinica.model.Paciente;
import pro.it.clinica.repository.NacionalidadeRepositorio;
import pro.it.clinica.repository.PacienteRepositorio;
import pro.it.clinica.serviceImpl.NacionalidadeServiceImpl;
import pro.it.clinica.serviceImpl.PacienteServiceImpl;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PacienteServiceImplTest {

    @Mock
    private PacienteRepositorio pacienteRepositorio;

    private PacienteServiceImpl pacienteService;
    private PacienteCommandToPaciente pacienteCommandToPaciente;
    private PacienteToPacienteCommand pacienteToPacienteCommand;

    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;

    @Mock
    private NacionalidadeRepositorio nacionalidadeRepositorio;

    private NacionalidadeServiceImpl nacionalidadeService;



    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        nacionalidadeCommandToNacionalidade = new NacionalidadeCommandToNacionalidade();
        nacionalidadeToNacionalidadeCommand = new NacionalidadeToNacionalidadeCommand();

        nacionalidadeService = new NacionalidadeServiceImpl(nacionalidadeRepositorio,
                nacionalidadeToNacionalidadeCommand,
                nacionalidadeCommandToNacionalidade
                );

        pacienteCommandToPaciente =  new PacienteCommandToPaciente(
                new EnderecoCommandToEndereco(),
                new NacionalidadeCommandToNacionalidade()
        );

        pacienteToPacienteCommand = new PacienteToPacienteCommand(
                new EnderecoToEnderecoCommand(),
                new NacionalidadeToNacionalidadeCommand()

        );
        pacienteService = new PacienteServiceImpl(pacienteRepositorio,pacienteCommandToPaciente, pacienteToPacienteCommand, nacionalidadeService);


    }

    @Test
    public void pesuisarIdTest(){
        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(1L);
        pacienteCommand.setNome("Esaldino");

        Paciente paciente = pacienteCommandToPaciente.convert(pacienteCommand);
        when(pacienteRepositorio.findById(anyLong())).thenReturn(Optional.of(paciente));

        PacienteCommand pacienteEdit = pacienteService.pesquisarId(1L);

        Assert.assertEquals(pacienteEdit.getId(),paciente.getId());


    }

    @Test
    public void adicionarTest(){

        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais("Angola");
        nacionalidadeCommand.setId(1L);

        NacionalidadeCommand nacionalidadeCommand1 = new NacionalidadeCommand();
        nacionalidadeCommand1.setPais("Brazil");
        nacionalidadeCommand1.setId(2L);

        Nacionalidade nacionalidade = nacionalidadeCommandToNacionalidade
                .convert(nacionalidadeCommand);
        Nacionalidade nacionalidade1 = nacionalidadeCommandToNacionalidade
                .convert(nacionalidadeCommand1);

        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(1L);
        pacienteCommand.setNome("Esaldino");
        pacienteCommand.getNumeroTelefone().add("5616165");
        pacienteCommand.getEmail().add("dfsdfsdfsdf");
        pacienteCommand.getNacionalidades().add(nacionalidadeCommand);
        pacienteCommand.getNacionalidades().add(nacionalidadeCommand1);
        pacienteCommand.setEndereco(new EnderecoCommand());

        Paciente paciente = pacienteCommandToPaciente.convert(pacienteCommand);

     /*   when(nacionalidadeRepositorio.findByPais(anyString()))
                .thenReturn( nacionalidade,nacionalidade );
    */
        when(nacionalidadeRepositorio.findByPais(anyString()))
                .thenReturn( null );

        when(nacionalidadeRepositorio.save(any(Nacionalidade.class)))
                .thenReturn( nacionalidade,nacionalidade1);

        when(pacienteRepositorio.save(any(Paciente.class))).thenReturn(paciente);

        PacienteCommand pacienteNovo = pacienteService.novo(pacienteCommand);

        Assert.assertNotNull(pacienteNovo);
        Assert.assertEquals(paciente.getId(),pacienteNovo.getId());
        Assert.assertTrue(pacienteNovo.getNumeroTelefone().size()>0);
        Assert.assertTrue(pacienteNovo.getEmail().size()>0);
        Assert.assertNotNull(pacienteCommand.getEndereco());
        Assert.assertEquals(2,pacienteNovo.getNacionalidades().size());
        Assert.assertEquals(pacienteNovo.getNacionalidades().size(),2);
        verify(nacionalidadeRepositorio, Mockito.times(2)).save(any(Nacionalidade.class));

        //PacienteCommand
    }
}
