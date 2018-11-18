package pro.it.gestao_clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.converter.*;
import pro.it.gestao_clinica.model.Paciente;
import pro.it.gestao_clinica.repository.PacienteRepositorio;
import pro.it.gestao_clinica.serviceImpl.PacienteServiceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PacienteServiceImplTest {

    @Mock
    private PacienteRepositorio pacienteRepositorio;

    private PacienteServiceImpl pacienteService;
    private PacienteCommandToPaciente pacienteCommandToPaciente;
    private PacienteToPacienteCommand pacienteToPacienteCommand;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        pacienteCommandToPaciente =  new PacienteCommandToPaciente(
                new EnderecoCommandToEndereco(),
                new ContactoCommandToContactoPaciente(),
                new NacionalidadeCommandToNacionalidade(),
                new ConsultaCommandToConsulta()
        );

        pacienteToPacienteCommand = new PacienteToPacienteCommand(
                new EnderecoToEnderecoCommand(),
                new ContactoPacienteToContactoCommand(),
                new NacionalidadeToNacionalidadeCommand(),
                new ConsultaToConsultaCommand()

        );
        pacienteService = new PacienteServiceImpl(pacienteRepositorio,pacienteCommandToPaciente, pacienteToPacienteCommand);


    }

    @Test
    public void adicionarTest(){

        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(1L);
        pacienteCommand.setNome("Esaldino");

        Paciente paciente = pacienteCommandToPaciente.convert(pacienteCommand);
        when(pacienteRepositorio.save(any(Paciente.class))).thenReturn(paciente);

        PacienteCommand pacienteNovo = pacienteService.adicionar(pacienteCommand);

        Assert.assertNotNull(pacienteNovo);
        Assert.assertEquals(paciente.getId(),pacienteNovo.getId());

        //PacienteCommand
    }
}
