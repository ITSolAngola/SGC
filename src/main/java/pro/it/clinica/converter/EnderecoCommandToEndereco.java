package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.model.padrao.Endereco;
@Component
public class EnderecoCommandToEndereco implements Converter<EnderecoCommand,Endereco> {

    @Override
    public Endereco convert(EnderecoCommand enderecoCommand) {
        if( enderecoCommand == null )
            return null;
        Endereco endereco = new Endereco();
        endereco.setBairro(enderecoCommand.getBairro());
        endereco.setCidade(enderecoCommand.getCidade());
        endereco.setMuinicipio(enderecoCommand.getMunicipio());
        endereco.setPais(enderecoCommand.getPais());
        endereco.setRua(enderecoCommand.getRua());
        endereco.setnCasa(enderecoCommand.getNumeroCasa());
        return endereco;
    }
}
