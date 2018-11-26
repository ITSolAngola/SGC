package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.model.Paciente;
import pro.it.clinica.model.padrao.Endereco;

import java.time.LocalDate;

public class PacienteToPacienteCommandTest {

        private PacienteToPacienteCommand pTpc;

        @Before
        public void setup(){
            pTpc = new PacienteToPacienteCommand(new EnderecoToEnderecoCommand(),
                    new NacionalidadeToNacionalidadeCommand());
        }

        @Test
        public void convertTest(){
            Paciente paciente = new Paciente();
            paciente.setNome("Esaldino");
            paciente.setDataNAscimento(LocalDate.of(1995,10,12));
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
