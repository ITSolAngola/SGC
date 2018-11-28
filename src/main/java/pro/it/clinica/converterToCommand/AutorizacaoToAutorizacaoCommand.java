package pro.it.clinica.converterToCommand;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.AutorizacaoCommand;
import pro.it.clinica.model.Autorizacao;

@Component
public class AutorizacaoToAutorizacaoCommand implements Converter<Autorizacao,AutorizacaoCommand> {

    @Override
    public AutorizacaoCommand convert(Autorizacao autorizacao) {
        AutorizacaoCommand autorizacaoCommand = new AutorizacaoCommand();
        autorizacaoCommand.setId(autorizacao.getId());
        autorizacaoCommand.setDescricao(autorizacao.getDescricao());
        return autorizacaoCommand;
    }
}
