package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.ContactoCommand;
import pro.it.gestao_clinica.model.ContactoPaciente;
import pro.it.gestao_clinica.model.padrao.Contacto;
@Component
public class ContactoCommandToContactoPaciente implements Converter<ContactoCommand,ContactoPaciente> {

    @Override
    public ContactoPaciente convert(ContactoCommand contactoCommand) {
        ContactoPaciente contacto = new ContactoPaciente();
        contacto.setEmail(contactoCommand.getEmail());
        contacto.setnPhone(contactoCommand.getNumeroTelefone());
        contacto.setId(contactoCommand.getId());
        return contacto;
    }
}
