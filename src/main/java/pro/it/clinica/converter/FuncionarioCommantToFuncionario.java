package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.Nacionalidade;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FuncionarioCommantToFuncionario implements Converter<MedicoCommand,Funcionario> {

    private EnderecoCommandToEndereco enderecoCommandToEndereco;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    public FuncionarioCommantToFuncionario(EnderecoCommandToEndereco enderecoCommandToEndereco, NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade) {
        this.enderecoCommandToEndereco = enderecoCommandToEndereco;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
    }

    @Override
    public Funcionario convert(MedicoCommand medicoCommand) {

        if( medicoCommand == null )
            return null;
        Funcionario funcionario = new Funcionario();
        funcionario.setId(medicoCommand.getId());
        funcionario.setNome(medicoCommand.getNome());
        funcionario.setDataNAscimento(medicoCommand.getDataNascimento());
        funcionario.setGenero(medicoCommand.getGenero());
        funcionario.setEndereco( enderecoCommandToEndereco.convert( medicoCommand.getEndereco() ) );
        funcionario.setSobreNome(medicoCommand.getSobreNome());
        funcionario.setEmail(medicoCommand.getEmail());
        funcionario.setEstadoCivil(medicoCommand.getEstadoCivil());

        funcionario.getNumTelefone().addAll( medicoCommand.getNumeroTelefone());
        funcionario.getNumTelefone().addAll( medicoCommand.getNumeroTelefone());

        Set<Nacionalidade> nacionalidades = medicoCommand.getNacionalidades()
                .stream()
                .map(nacionalidadeCommandToNacionalidade::convert)
                .collect(Collectors.toSet());
        funcionario.setNacionalidades(nacionalidades);
        return  funcionario;
    }
}
