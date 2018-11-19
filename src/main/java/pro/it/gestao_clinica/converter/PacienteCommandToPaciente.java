package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.model.ContactoPaciente;
import pro.it.gestao_clinica.model.Nacionalidade;
import pro.it.gestao_clinica.model.Paciente;

import java.util.Set;
import java.util.stream.Collectors;
@Component
public class PacienteCommandToPaciente implements Converter<PacienteCommand,Paciente> {

    private EnderecoCommandToEndereco enderecoCommandToEndereco;
    private ContactoCommandToContactoPaciente contactoCommandToContacto;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;
    private ConsultaCommandToConsulta consultaCommandToConsulta;

    public PacienteCommandToPaciente(EnderecoCommandToEndereco enderecoCommandToEndereco, ContactoCommandToContactoPaciente contactoCommandToContacto, NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade, ConsultaCommandToConsulta consultaCommandToConsulta) {
        this.enderecoCommandToEndereco = enderecoCommandToEndereco;
        this.contactoCommandToContacto = contactoCommandToContacto;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
        this.consultaCommandToConsulta = consultaCommandToConsulta;
    }

    @Override
    public Paciente convert(PacienteCommand pacienteCommand) {

        Paciente paciente = new Paciente();
        paciente.setId(pacienteCommand.getId());
        paciente.setNome(pacienteCommand.getNome());
        paciente.setDataNAscimento(pacienteCommand.getDataNAscimento());
        paciente.setGenero(pacienteCommand.getGenero());
        paciente.setEndereco( enderecoCommandToEndereco.convert( pacienteCommand.getEndereco() ) );
        paciente.setPeso(pacienteCommand.getPeso());
        paciente.setSobreNome(pacienteCommand.getSobreNome());
        paciente.setEstadoCivil(pacienteCommand.getEstadoCivil());

        Set<ContactoPaciente> contactos = pacienteCommand
                    .getContactos()
                .stream()
                    .map(contactoCommand->{
                       ContactoPaciente contactoPaciente = contactoCommandToContacto.convert(contactoCommand);
                       contactoPaciente.setPaciente(paciente);
                       return  contactoPaciente;
                    })
                    .collect(Collectors.toSet());

        paciente.setContactos(contactos);

        Set<Nacionalidade> nacionalidades = pacienteCommand.getNacionalidades()
                .stream()
                .map(nacionalidadeCommandToNacionalidade::convert)
                .collect(Collectors.toSet());


        nacionalidades.forEach(nacionalidade -> nacionalidade.getPacientes().add(paciente) );
        paciente.setNacionalidades(nacionalidades);


        paciente.setConsultas(pacienteCommand.getConsultas()
                                    .stream()
                                    .map(consultaCommandToConsulta::convert)
                                    .collect(Collectors.toSet()));

        return paciente;
    }
}
