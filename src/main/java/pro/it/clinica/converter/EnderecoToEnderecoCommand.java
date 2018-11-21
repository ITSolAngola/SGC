package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.model.padrao.Endereco;
@Component
public class EnderecoToEnderecoCommand implements Converter<Endereco,EnderecoCommand> {

    @Override
    public EnderecoCommand convert(Endereco endereco) {
        if( endereco == null )
            return null;
        EnderecoCommand enderecoCommand = new EnderecoCommand();
        enderecoCommand.setBairro(endereco.getBairro());
        enderecoCommand.setCidade(endereco.getCidade());
        enderecoCommand.setMunicipio(endereco.getMuinicipio());
        enderecoCommand.setPais(endereco.getPais());
        enderecoCommand.setRua(endereco.getRua());
        enderecoCommand.setNumeroCasa(endereco.getnCasa());
        return enderecoCommand;
    }

}
