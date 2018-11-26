package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.model.Funcionario;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MedicoToMedicoCommand implements Converter<Funcionario, MedicoCommand> {

    private FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;
    private EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand;

    public MedicoToMedicoCommand(FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand, EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand) {
        this.funcionarioToFuncionarioCommand = funcionarioToFuncionarioCommand;
        this.especialidadeToEspecialidadeCommand = especialidadeToEspecialidadeCommand;
    }

    @Override
    public MedicoCommand convert(Funcionario funcionario) {

        MedicoCommand medicoCommand = get( funcionarioToFuncionarioCommand.convert(funcionario) );

        medicoCommand.setEspecialidades( funcionario.getMedicoEspecialidades()
                    .stream()
                    .map( medicoEspecialidade->medicoEspecialidade.getEspecialidade() )
                    .map(especialidadeToEspecialidadeCommand::convert)
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
