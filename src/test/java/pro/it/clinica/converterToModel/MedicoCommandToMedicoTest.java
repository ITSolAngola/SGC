package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.service.ServiceEspecialidade;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MedicoCommandToMedicoTest {

    @Mock
    private ServiceEspecialidade serviceEspecialidade;


    private FuncionarioCommantToFuncionario funcionarioCommantToFuncionario;
    private MedicoCommandToMedico medicoCommandToMedico;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        funcionarioCommantToFuncionario =
                new FuncionarioCommantToFuncionario(new EnderecoCommandToEndereco(),
                                                        new NacionalidadeCommandToNacionalidade());
        medicoCommandToMedico = new MedicoCommandToMedico(new EspecialidadeCommandToEspecialidade(),
                        funcionarioCommantToFuncionario,new NacionalidadeCommandToNacionalidade(),
                        new ConsultaCommandToConsulta());
    }

    @Test
    public void converterTest(){

        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setId(1L);
        medicoCommand.setDataNascimento(LocalDate.of(2014,12,8));
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        Set<NacionalidadeCommand> nacionalidadeCommandSet = new HashSet<>();
        nacionalidadeCommandSet.add(nacionalidadeCommand);
        medicoCommand.setNacionalidades(nacionalidadeCommandSet);

        EnderecoCommand enderecoCommand = new EnderecoCommand();
        medicoCommand.setEndereco(enderecoCommand);

        Set<EspecialidadeCommand> especialidadeCommandList = Arrays.asList(
                        new EspecialidadeCommand(),
                        new EspecialidadeCommand()
        ).stream().collect(Collectors.toSet());
        medicoCommand.setEspecialidades(especialidadeCommandList);

        when(serviceEspecialidade.valida(any(EspecialidadeCommand.class))).thenReturn(new EspecialidadeCommand());
        Funcionario funcionarioMedico = medicoCommandToMedico.convert(medicoCommand);

        Assert.assertNotNull(funcionarioMedico);
     //   Assert.assertEquals(funcionarioMedico.getMedicoEspecialidades().size(),medicoCommand.getEspecialidades().size());
        Assert.assertNotNull(funcionarioMedico.getEndereco());
    }


}
