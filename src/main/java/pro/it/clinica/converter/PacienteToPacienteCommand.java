package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.ContactoCommand;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.model.Paciente;

import java.util.Set;
import java.util.stream.Collectors;
@Component
public class PacienteToPacienteCommand implements Converter<Paciente,PacienteCommand> {

    private EnderecoToEnderecoCommand enderecoToEnderecoCommand;
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;

    public PacienteToPacienteCommand(EnderecoToEnderecoCommand enderecoToEnderecoCommand,
                                     NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand) {
        this.enderecoToEnderecoCommand = enderecoToEnderecoCommand;
        this.nacionalidadeToNacionalidadeCommand = nacionalidadeToNacionalidadeCommand;
    }

    @Override
    public PacienteCommand convert(Paciente paciente) {

        if( paciente == null )
            return null;

        PacienteCommand pacienteCommand = new PacienteCommand();
        pacienteCommand.setId(paciente.getId());
        pacienteCommand.setNome(paciente.getNome());
        pacienteCommand.setDataNascimento(paciente.getDataNAscimento());
        pacienteCommand.setEndereco(enderecoToEnderecoCommand.convert(paciente.getEndereco()));
        pacienteCommand.setPeso(paciente.getPeso());
        pacienteCommand.setGenero(paciente.getGenero());
        pacienteCommand.setSobreNome(paciente.getSobreNome());
        pacienteCommand.setEstadoCivil(paciente.getEstadoCivil());
        pacienteCommand.setNumeroTelefone(paciente.getNumTelefone());
        pacienteCommand.setEmail(paciente.getEmail());

        pacienteCommand.setNacionalidades(paciente.getNacionalidades()
                .stream()
                .map(nacionalidadeToNacionalidadeCommand::convert)
                .collect(Collectors.toSet()));

        return pacienteCommand;
    }
}
