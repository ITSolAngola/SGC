package pro.it.clinica.converterToCommand;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.model.Funcionario;

import java.util.stream.Collectors;

@Component
public class MedicoToMedicoCommand implements Converter<Funcionario, MedicoCommand> {

    private FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;
    private EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand;
    private ConsultaToConsultaCommand consultaToConsultaCommand;
    public MedicoToMedicoCommand(FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand, EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand, ConsultaToConsultaCommand consultaToConsultaCommand) {
        this.funcionarioToFuncionarioCommand = funcionarioToFuncionarioCommand;
        this.especialidadeToEspecialidadeCommand = especialidadeToEspecialidadeCommand;
        this.consultaToConsultaCommand = consultaToConsultaCommand;
    }

    @Override
    public MedicoCommand convert(Funcionario funcionario) {

        if (funcionario == null )
            return null;

        MedicoCommand medicoCommand = get( funcionarioToFuncionarioCommand.convert(funcionario) );
        medicoCommand.setEspecialidades(funcionario.getEspecialidades()
                                                .stream()
                                                .map(especialidadeToEspecialidadeCommand::convert)
                                                .collect(Collectors.toSet()));

        medicoCommand.setConsultas(funcionario.getConsultas()
                                            .stream()
                                            .map(consultaToConsultaCommand::convert)
                                            .collect(Collectors.toSet()));
        return medicoCommand;
    }

    public MedicoCommand get(FuncionarioCommand funcionarioCommand){
        MedicoCommand medicoCommand = new MedicoCommand();
        medicoCommand.setId(funcionarioCommand.getId());
        medicoCommand.setNome(funcionarioCommand.getNome());
        medicoCommand.setDataNascimento(funcionarioCommand.getDataNascimento());
        medicoCommand.setGenero(funcionarioCommand.getGenero());
        medicoCommand.setEndereco(funcionarioCommand.getEndereco()  );
        medicoCommand.setCargo(funcionarioCommand.getCargo());
        medicoCommand.setSobreNome( funcionarioCommand.getSobreNome());
        medicoCommand.setEmail(funcionarioCommand.getEmail());
        medicoCommand.setEstadoCivil(funcionarioCommand.getEstadoCivil());

        medicoCommand.setNumeroTelefone(funcionarioCommand.getNumeroTelefone());
        medicoCommand.setNacionalidades(funcionarioCommand.getNacionalidades());

        return medicoCommand;
    }

}
