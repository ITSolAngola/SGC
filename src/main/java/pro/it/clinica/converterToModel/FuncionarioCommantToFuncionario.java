package pro.it.clinica.converterToModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.Nacionalidade;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FuncionarioCommantToFuncionario implements Converter<FuncionarioCommand,Funcionario> {

    private EnderecoCommandToEndereco enderecoCommandToEndereco;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    public FuncionarioCommantToFuncionario(EnderecoCommandToEndereco enderecoCommandToEndereco, NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade) {
        this.enderecoCommandToEndereco = enderecoCommandToEndereco;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
    }

    @Override
    public Funcionario convert(FuncionarioCommand funcionarioCommand) {

        if( funcionarioCommand == null )
            return null;
        Funcionario funcionario = new Funcionario();
        funcionario.setId(funcionarioCommand.getId());
        funcionario.setNome(funcionarioCommand.getNome());
        funcionario.setDataNascimento(funcionarioCommand.getDataNascimento());
        funcionario.setCargo(funcionarioCommand.getCargo());
        funcionario.setGenero(funcionarioCommand.getGenero());
        funcionario.setEndereco( enderecoCommandToEndereco.convert( funcionarioCommand.getEndereco() ) );
        funcionario.setSobreNome(funcionarioCommand.getSobreNome());
        funcionario.setEmail(funcionarioCommand.getEmail());
        funcionario.setEstadoCivil(funcionarioCommand.getEstadoCivil());

        funcionario.getNumTelefone().addAll( funcionarioCommand.getNumeroTelefone());

        Set<Nacionalidade> nacionalidades = funcionarioCommand.getNacionalidades()
                .stream()
                .map(nacionalidadeCommandToNacionalidade::convert)
                .collect(Collectors.toSet());
        funcionario.setNacionalidades(nacionalidades);
        return  funcionario;
    }
}
