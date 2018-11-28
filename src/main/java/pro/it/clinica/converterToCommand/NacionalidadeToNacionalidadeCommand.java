package pro.it.clinica.converterToCommand;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Nacionalidade;
@Component
public class NacionalidadeToNacionalidadeCommand implements Converter<Nacionalidade,NacionalidadeCommand> {
    @Override
    public NacionalidadeCommand convert(Nacionalidade nacionalidade) {
        if( nacionalidade == null )
            return null;
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais(nacionalidade.getPais());
        nacionalidadeCommand.setId(nacionalidade.getId());
        return nacionalidadeCommand;
    }
}
