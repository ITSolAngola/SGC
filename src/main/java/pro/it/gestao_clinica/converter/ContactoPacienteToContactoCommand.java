package pro.it.gestao_clinica.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.ContactoCommand;
import pro.it.gestao_clinica.model.ContactoPaciente;
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
