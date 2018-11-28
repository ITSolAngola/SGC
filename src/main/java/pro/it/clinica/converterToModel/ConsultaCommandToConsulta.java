package pro.it.clinica.converterToModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.model.Consulta;

@Component
public class ConsultaCommandToConsulta implements Converter<ConsultaCommand,Consulta> {

    @Override
    public Consulta convert(ConsultaCommand consultaCommand) {
        if(consultaCommand==null)
            return null;

        Consulta consulta = new Consulta();
        consulta.setId(consultaCommand.getId());
        consulta.setDataConsulta(consultaCommand.getDataConsulta());
        consulta.setDataActual(consultaCommand.getDataConsulta());
        consulta.setEstado(consultaCommand.getEstado());
        consulta.setDescricao(consultaCommand.getDescricao());
        return consulta;
    }

}
