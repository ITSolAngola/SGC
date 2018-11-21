package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.model.Consulta;

@Component
public class ConsultaCommandToConsulta implements Converter<ConsultaCommand,Consulta> {


    @Override
    public Consulta convert(ConsultaCommand consultaCommand) {

        Consulta consulta = new Consulta();
        consulta.setId(consultaCommand.getId());
        consulta.setDataConsulta(consultaCommand.getDataConsulta());
        consulta.setDataMarcada(consultaCommand.getDataActual());
        consulta.setEstado(consultaCommand.getEstado());
        return consulta;
    }
}