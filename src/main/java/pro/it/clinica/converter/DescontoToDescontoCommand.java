package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.DescontoCommand;
import pro.it.clinica.model.Desconto;
@Component
public class DescontoToDescontoCommand implements Converter<Desconto,DescontoCommand> {
    @Override
    public DescontoCommand convert(Desconto desconto) {
        if( desconto == null )
            return null;
        DescontoCommand descontoCommand = new DescontoCommand();
        descontoCommand.setDescricao(desconto.getDescricao());
        descontoCommand.setLimite(desconto.getLimite());
        descontoCommand.setValor(desconto.getValor());
        return descontoCommand;
    }
}
