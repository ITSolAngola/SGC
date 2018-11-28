package pro.it.clinica.converterToModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.model.Paciente;

import java.util.stream.Collectors;

@Component
public class PacienteCommandToPaciente implements Converter<PacienteCommand,Paciente> {

    private EnderecoCommandToEndereco enderecoCommandToEndereco;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;
    private ConsultaCommandToConsulta consultaCommandToConsulta;

    public PacienteCommandToPaciente(EnderecoCommandToEndereco enderecoCommandToEndereco, NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade, ConsultaCommandToConsulta consultaCommandToConsulta) {
        this.enderecoCommandToEndereco = enderecoCommandToEndereco;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
        this.consultaCommandToConsulta = consultaCommandToConsulta;
    }

    @Override
    public Paciente convert(PacienteCommand pacienteCommand) {

        if( pacienteCommand == null )
            return null;
        Paciente paciente = new Paciente();
        paciente.setId(pacienteCommand.getId());
        paciente.setNome(pacienteCommand.getNome());
        paciente.setDataNAscimento(pacienteCommand.getDataNascimento());
        paciente.setGenero(pacienteCommand.getGenero());
        paciente.setEndereco( enderecoCommandToEndereco.convert( pacienteCommand.getEndereco() ) );
        paciente.setPeso(pacienteCommand.getPeso());
        paciente.setSobreNome(pacienteCommand.getSobreNome());
        paciente.setEstadoCivil(pacienteCommand.getEstadoCivil());
        paciente.setNumTelefone(pacienteCommand.getNumeroTelefone());
        paciente.setEmail(pacienteCommand.getEmail());
        pacienteCommand.getNacionalidades()
                .stream()
                .map(nacionalidadeCommandToNacionalidade::convert)
                .forEach(paciente::addNacionalidade);

        paciente.setConsultas(pacienteCommand.getConsultas()
                .stream()
                .map(consultaCommandToConsulta::convert)
                .collect(Collectors.toSet()));


        return paciente;
    }
}
