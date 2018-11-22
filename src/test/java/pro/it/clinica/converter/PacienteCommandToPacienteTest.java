package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.model.Paciente;

public class PacienteCommandToPacienteTest {

    private PacienteCommandToPaciente pacienteCommandToPaciente;

    @Before
    public void setup(){
        pacienteCommandToPaciente = new PacienteCommandToPaciente(new EnderecoCommandToEndereco(),
                new ContactoCommandToContactoPaciente(),
                new NacionalidadeCommandToNacionalidade(),
                new ConsultaCommandToConsulta());
    }

    @Test
    public void convertTest(){
        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(1L);
    /*    pacienteCommand.setNome("Esaldino");
        pacienteCommand.setDataNAscimento(LocalDate.of(1995,10,12));

        ContactoCommand contacto = new ContactoCommand(1L,"943553169","esaldino@gmail.com");
        pacienteCommand.getContactos().add(contacto);
        ConsultaCommand consultaCommand = new ConsultaCommand();
        consultaCommand.setEstado(false);
        consultaCommand.setId(20L);
        consultaCommand.setDataActual(LocalDateTime.now());
        consultaCommand.setDataConsulta(LocalDateTime.now());
        pacienteCommand.getConsultas().add(consultaCommand);

        EnderecoCommand enderecoCommand = new EnderecoCommand();
        enderecoCommand.setNCasa("20");
        pacienteCommand.setEndereco(enderecoCommand);*/

        Paciente pacienteBusca = pacienteCommandToPaciente.convert(pacienteCommand);

        Assert.assertNotNull(pacienteBusca);
        Assert.assertEquals(pacienteCommand.getId(),pacienteBusca.getId());
    //    Assert.assertTrue(pacienteBusca.getContactos().size()>0);
 //       Assert.assertTrue(pacienteBusca.getConsultas().size()>0);
     //   Assert.assertNotNull(pacienteBusca.getEndereco());
    }
}
