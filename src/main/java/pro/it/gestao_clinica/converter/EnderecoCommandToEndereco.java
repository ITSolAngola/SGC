package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.EnderecoCommand;
import pro.it.gestao_clinica.model.padrao.Endereco;
@Component
public class EnderecoCommandToEndereco implements Converter<EnderecoCommand,Endereco> {

    @Override
    public Endereco convert(EnderecoCommand enderecoCommand) {
        if( enderecoCommand == null )
            return null;
        Endereco endereco = new Endereco();
        endereco.setBairro(enderecoCommand.getBairro());
        endereco.setCidade(enderecoCommand.getCidade());
        endereco.setMuinicipio(enderecoCommand.getMuinicipio());
        endereco.setPais(enderecoCommand.getPais());
        endereco.setRua(enderecoCommand.getRua());
        endereco.setnCasa(enderecoCommand.getNCasa());
        return endereco;
    }
}
