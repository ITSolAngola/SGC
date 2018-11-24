package pro.it.clinica.converter;


import org.springframework.core.convert.converter.Converter;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Funcionario;
import java.util.Set;
import java.util.stream.Collectors;

public class FuncionarioToFuncionarioCommand implements Converter<Funcionario,FuncionarioCommand> {

    private EnderecoToEnderecoCommand enderecoToEnderecoCommand;
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;

    public FuncionarioToFuncionarioCommand(EnderecoToEnderecoCommand enderecoToEnderecoCommand, NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand) {
        this.enderecoToEnderecoCommand = enderecoToEnderecoCommand;
        this.nacionalidadeToNacionalidadeCommand = nacionalidadeToNacionalidadeCommand;
    }

    @Override
    public FuncionarioCommand convert(Funcionario funcionario) {

        if( funcionario == null )
            return null;
        FuncionarioCommand funcionarioCommand = new FuncionarioCommand();
        funcionarioCommand.setId(funcionario.getId());
        funcionarioCommand.setNome(funcionario.getNome());
        funcionarioCommand.setDataNascimento(funcionario.getDataNAscimento());
        funcionarioCommand.setGenero(funcionario.getGenero());
        funcionarioCommand.setEndereco( enderecoToEnderecoCommand.convert( funcionario.getEndereco() ) );
        funcionarioCommand.setSobreNome(funcionario.getSobreNome());
        funcionarioCommand.setEmail(funcionario.getEmail());
        funcionarioCommand.setEstadoCivil(funcionario.getEstadoCivil());

        funcionarioCommand.getNumeroTelefone().addAll( funcionario.getNumTelefone());
        funcionarioCommand.getEmail().addAll( funcionario.getEmail());

        Set<NacionalidadeCommand> nacionalidadeCommands = funcionario.getNacionalidades()
                .stream()
                .map(nacionalidadeToNacionalidadeCommand::convert)
                .collect(Collectors.toSet());
        funcionarioCommand.setNacionalidades(nacionalidadeCommands);
        return  funcionarioCommand;
    }

}
