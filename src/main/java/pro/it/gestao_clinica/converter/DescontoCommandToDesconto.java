package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.DescontoCommand;
import pro.it.gestao_clinica.model.Desconto;
@Component
public class DescontoCommandToDesconto implements Converter<DescontoCommand,Desconto> {
    @Override
    public Desconto convert(DescontoCommand descontoCommand) {
        Desconto desconto = new Desconto();
        desconto.setDescricao(descontoCommand.getDescricao());
        desconto.setLimite(descontoCommand.getLimite());
        desconto.setValor(descontoCommand.getValor());
        return desconto;
    }
}
