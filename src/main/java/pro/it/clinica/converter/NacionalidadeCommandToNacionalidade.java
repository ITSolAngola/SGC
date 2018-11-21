package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Nacionalidade;
@Component
public class NacionalidadeCommandToNacionalidade implements Converter<NacionalidadeCommand,Nacionalidade> {

    @Override
    public Nacionalidade convert(NacionalidadeCommand nacionalidadeCommand) {
        Nacionalidade nacionalidade = new Nacionalidade();
        nacionalidade.setPais(nacionalidadeCommand.getPais());
        nacionalidade.setId(nacionalidadeCommand.getId());
        return nacionalidade;
    }
}
