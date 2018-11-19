package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.NacionalidadeCommand;
import pro.it.gestao_clinica.model.Nacionalidade;
@Component
public class NacionalidadeToNacionalidadeCommand implements Converter<Nacionalidade,NacionalidadeCommand> {
    @Override
    public NacionalidadeCommand convert(Nacionalidade nacionalidade) {
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais(nacionalidade.getPais());
        nacionalidadeCommand.setId(nacionalidade.getId());
        return nacionalidadeCommand;
    }
}
