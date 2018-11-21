package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.ContactoCommand;
import pro.it.clinica.model.ContactoPaciente;

public class ContactoPacienteToContactoCommandTest {

    private ContactoPacienteToContactoCommand contactoPacienteToContactoCommand;

    @Before
    public void setup(){
        contactoPacienteToContactoCommand = new ContactoPacienteToContactoCommand();
    }

    @Test
    public void converterTest(){
        ContactoPaciente contactoPaciente = new ContactoPaciente();
        contactoPaciente.setEmail("Esaldino fonseca");
        contactoPaciente.setnPhone("943553169");
        contactoPaciente.setId(1L);

        ContactoCommand contactoCommand = contactoPacienteToContactoCommand.convert(contactoPaciente);
        Assert.assertEquals(contactoCommand.getEmail(),contactoPaciente.getEmail());
        Assert.assertTrue(contactoCommand.getId().equals(1L));
    }
}
