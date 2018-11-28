package pro.it.clinica.converterToModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.DescontoCommand;
import pro.it.clinica.model.Desconto;
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
