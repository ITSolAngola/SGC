package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.ContactoCommand;
import pro.it.clinica.model.ContactoPaciente;

public class ContactoCommandToContactoPacienteTest {


    private ContactoCommandToContactoPaciente contactoCommandToContactoPaciente;

    @Before
    public void setup(){
        contactoCommandToContactoPaciente = new ContactoCommandToContactoPaciente();
    }

    @Test public void contactoConverter(){
        ContactoCommand contactoCommand = new ContactoCommand();
        contactoCommand.setNumeroTelefone("898898");
        contactoCommand.setEmail("esaldinofonseca@gmail.com");
        contactoCommand.setId(1L);

        ContactoPaciente cp = contactoCommandToContactoPaciente.convert(contactoCommand);

        Assert.assertNotNull(cp);
        Assert.assertEquals(contactoCommand.getId(),cp.getId());
    }
}
