package pro.it.clinica.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.ContactoCommand;
import pro.it.clinica.model.ContactoPaciente;
@Component
public class ContactoPacienteToContactoCommand implements Converter<ContactoPaciente,ContactoCommand> {

    @Override
    public ContactoCommand convert(ContactoPaciente contactoPaciente) {
        ContactoCommand contactoCommand = new ContactoCommand();
        contactoCommand.setEmail(contactoPaciente.getEmail());
        contactoCommand.setNumeroTelefone(contactoPaciente.getnPhone());
        contactoCommand.setId(contactoPaciente.getId());
        return contactoCommand;
    }
}
