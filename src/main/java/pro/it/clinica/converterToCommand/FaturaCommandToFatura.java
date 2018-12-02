package pro.it.clinica.converterToCommand;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.FaturaCommand;
import pro.it.clinica.converterToModel.ConsultaCommandToConsulta;
import pro.it.clinica.model.Fatura;

@Component
public class FaturaCommandToFatura implements Converter<FaturaCommand,Fatura> {

    private ConsultaCommandToConsulta consultaCommandToConsulta;

    @Override
    public Fatura convert(FaturaCommand faturaCommand) {
        if( faturaCommand == null )
            return null;
        Fatura fatura = new Fatura();
        fatura.setId(faturaCommand.getId());
        fatura.setData(faturaCommand.getData());
        fatura.setNFatura(faturaCommand.getNFatura());
        fatura.setTipoFactura(faturaCommand.getTipoFactura());
        fatura.setTipoPagamento(faturaCommand.getTipoPagamento());
        faturaCommand.getConsultas()
                                    .stream()
                                    .map(consultaCommandToConsulta::convert)
                                    .forEach(fatura::addConsulta);
        return fatura;
    }

}
