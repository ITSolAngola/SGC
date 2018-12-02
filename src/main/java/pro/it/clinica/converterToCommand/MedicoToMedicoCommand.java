package pro.it.clinica.converterToCommand;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.model.Funcionario;

import java.util.stream.Collectors;

@Component
public class MedicoToMedicoCommand implements Converter<Funcionario, MedicoCommand> {

    private EnderecoToEnderecoCommand enderecoToEnderecoCommand;
    private EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand;
    private ConsultaToConsultaCommand consultaToConsultaCommand;
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;

    public MedicoToMedicoCommand(EnderecoToEnderecoCommand enderecoToEnderecoCommand,
                                 EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand,
                                 ConsultaToConsultaCommand consultaToConsultaCommand,
                                 NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand) {
        this.enderecoToEnderecoCommand = enderecoToEnderecoCommand;
        this.especialidadeToEspecialidadeCommand = especialidadeToEspecialidadeCommand;
        this.consultaToConsultaCommand = consultaToConsultaCommand;
        this.nacionalidadeToNacionalidadeCommand = nacionalidadeToNacionalidadeCommand;
    }

    @Override
    public MedicoCommand convert(Funcionario funcionario) {

        if (funcionario == null )
            return null;

        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setId(funcionario.getId());
        medicoCommand.setNome(funcionario.getNome());
        medicoCommand.setDataNascimento(funcionario.getDataNascimento());
        medicoCommand.setGenero(funcionario.getGenero());
        medicoCommand.setEndereco(enderecoToEnderecoCommand.convert( funcionario.getEndereco() ) );
        medicoCommand.setCargo(funcionario.getCargo());
        medicoCommand.setSobreNome( funcionario.getSobreNome());
        medicoCommand.setEmail(funcionario.getEmail());
        medicoCommand.setEstadoCivil(funcionario.getEstadoCivil());

        medicoCommand.setNumeroTelefone(funcionario.getNumTelefone());

        medicoCommand.setNacionalidades(funcionario.getNacionalidades().stream()
                                                    .map(nacionalidadeToNacionalidadeCommand::convert)
                                                    .collect(Collectors.toSet()));

        medicoCommand.setEspecialidades(funcionario.getEspecialidades()
                                                .stream()
                                                .map(especialidadeToEspecialidadeCommand::convert)
                                                .collect(Collectors.toSet()));

        System.out.println("Consultas dadas : " + funcionario.getConsultas().size());

        medicoCommand.setConsultas(funcionario.getConsultas()
                                            .stream()
                                            .map(consultaToConsultaCommand::convert)
                                            .collect(Collectors.toSet()));
        return medicoCommand;
    }

}
