package pro.it.clinica.converterToModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.FaturaCommand;
import pro.it.clinica.converterToCommand.ConsultaToConsultaCommand;
import pro.it.clinica.model.Fatura;
import java.util.stream.Collectors;
@Component
public class FaturaToFaturaCommand implements Converter<Fatura,FaturaCommand> {

    private ConsultaToConsultaCommand consultaToConsultaCommand;

    @Override
    public FaturaCommand convert(Fatura fatura) {

        if(fatura==null) return null;
        FaturaCommand faturaCommand = new FaturaCommand();
        faturaCommand.setTipoFactura(fatura.getTipoFactura());
        faturaCommand.setData(fatura.getData());
        faturaCommand.setId(fatura.getId());
        faturaCommand.setNFatura(fatura.getNFatura());
        faturaCommand.setTipoPagamento(fatura.getTipoPagamento());
        faturaCommand.setValorTotal(fatura.getValorTotal());
        faturaCommand.setConsultas(fatura.getConsultas()
                                .stream().map(consultaToConsultaCommand::convert)
                                .collect(Collectors.toSet()));
        return faturaCommand;
    }
}
