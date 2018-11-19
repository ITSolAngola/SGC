package pro.it.gestao_clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.model.Consulta;
import pro.it.gestao_clinica.model.ContactoPaciente;
import pro.it.gestao_clinica.model.Desconto;
import pro.it.gestao_clinica.model.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PacienteToPacienteCommandTest {

        private PacienteToPacienteCommand pTpc;

        @Before
        public void setup(){
            pTpc = new PacienteToPacienteCommand(new EnderecoToEnderecoCommand(),
                    new ContactoPacienteToContactoCommand(),
                    new NacionalidadeToNacionalidadeCommand(),
                    new ConsultaToConsultaCommand());
        }

        @Test
        public void convertTest(){
            Paciente paciente = new Paciente();
            paciente.setNome("Esaldino");
            paciente.setDataNAscimento(LocalDate.of(1995,10,12));
            paciente.setId(20L);
            ContactoPaciente contacto = new ContactoPaciente("943553169","esaldino@gmail.com");
            paciente.addContacto(contacto);
            Consulta consulta = new Consulta();
            consulta.setEstado(false);
            consulta.setId(20L);
            consulta.setDataMarcada(LocalDateTime.now());
            consulta.setDataConsulta(LocalDateTime.now());
            paciente.addConsulta(consulta);

            PacienteCommand pacienteCommand = pTpc.convert(paciente);
            Assert.assertEquals(pacienteCommand.getId(),paciente.getId());
            Assert.assertTrue(pacienteCommand.getContactos().size()>0);
            Assert.assertTrue(pacienteCommand.getConsultas().size()>0);

          //  Assert.assertNotNull();
        }
}
