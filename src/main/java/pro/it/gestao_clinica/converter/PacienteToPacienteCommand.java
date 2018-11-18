package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.ContactoCommand;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.model.Paciente;

import java.util.Set;
import java.util.stream.Collectors;
@Component
public class PacienteToPacienteCommand implements Converter<Paciente,PacienteCommand> {

    private EnderecoToEnderecoCommand enderecoToEnderecoCommand;
    private ContactoPacienteToContactoCommand contactoPacienteToContactoCommand;
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;
    private ConsultaToConsultaCommand consultaToConsultaCommand;

    public PacienteToPacienteCommand(EnderecoToEnderecoCommand enderecoToEnderecoCommand,
                                     ContactoPacienteToContactoCommand contactoPacienteToContactoCommand,
                                     NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand, ConsultaToConsultaCommand consultaToConsultaCommand) {
        this.enderecoToEnderecoCommand = enderecoToEnderecoCommand;
        this.contactoPacienteToContactoCommand = contactoPacienteToContactoCommand;
        this.nacionalidadeToNacionalidadeCommand = nacionalidadeToNacionalidadeCommand;
        this.consultaToConsultaCommand = consultaToConsultaCommand;
    }

    @Override
    public PacienteCommand convert(Paciente paciente) {
        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(paciente.getId());
        pacienteCommand.setNome(paciente.getNome());
        pacienteCommand.setDataNAscimento(paciente.getDataNAscimento());
        pacienteCommand.setEndereco(enderecoToEnderecoCommand.convert(paciente.getEndereco()));
        pacienteCommand.setPeso(paciente.getPeso());
        pacienteCommand.setSobreNome(paciente.getSobreNome());
        Set<ContactoCommand> contactos = paciente.getContactos().stream()
                .map(contactoPacienteToContactoCommand::convert)
                .collect(Collectors.toSet());
        pacienteCommand.setContactos(contactos);
        pacienteCommand.setNacionalidades(paciente.getNacionalidades()
                .stream()
                .map(nacionalidadeToNacionalidadeCommand::convert)
                .collect(Collectors.toSet()));
        pacienteCommand.setConsultas(paciente.getConsultas()
                .stream()
                .map(consultaToConsultaCommand::convert)
                .collect(Collectors.toSet()));
        return pacienteCommand;
    }
}
