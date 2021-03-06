package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.converterToCommand.ConsultaToConsultaCommand;
import pro.it.clinica.converterToCommand.EnderecoToEnderecoCommand;
import pro.it.clinica.converterToCommand.NacionalidadeToNacionalidadeCommand;
import pro.it.clinica.converterToCommand.PacienteToPacienteCommand;
import pro.it.clinica.model.Paciente;
import pro.it.clinica.model.padrao.Endereco;

import java.time.LocalDate;

public class PacienteToPacienteCommandTest {

        private PacienteToPacienteCommand pTpc;
        private ConsultaToConsultaCommand consultaToConsultaCommand;

        @Before
        public void setup(){
            pTpc = new PacienteToPacienteCommand(new EnderecoToEnderecoCommand(),
                    new NacionalidadeToNacionalidadeCommand(), consultaToConsultaCommand);
        }

        @Test
        public void convertTest(){
            Paciente paciente = new Paciente();
            paciente.setNome("Esaldino");
            paciente.setDataNascimento(LocalDate.of(1995,10,12));
            paciente.setId(20L);
            paciente.getNumTelefone().add("9340032423");
            paciente.getEmail().add("esaldinofonseca@gmail.com");
            paciente.setEndereco( new Endereco());

            PacienteCommand pacienteCommand = pTpc.convert(paciente);
            Assert.assertEquals(pacienteCommand.getId(),paciente.getId());
            Assert.assertTrue(pacienteCommand.getNumeroTelefone().size()>0);
            Assert.assertTrue(pacienteCommand.getEmail().size()>0);
            Assert.assertNotNull(pacienteCommand.getEndereco());

          //  Assert.assertNotNull();
        }
}
