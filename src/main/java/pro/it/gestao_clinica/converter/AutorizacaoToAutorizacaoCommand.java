package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.AutorizacaoCommand;
import pro.it.gestao_clinica.model.Autorizacao;

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
