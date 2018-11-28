package pro.it.clinica.converterToCommand;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.model.Consulta;
@Component
public class ConsultaToConsultaCommand implements Converter<Consulta,ConsultaCommand> {
    @Override
    public ConsultaCommand convert(Consulta consulta) {

        if(consulta==null)
            return null;

        ConsultaCommand consultaCommand = new ConsultaCommand();
        consultaCommand.setId(consulta.getId());
        consultaCommand.setDataConsulta(consulta.getDataConsulta());
        consultaCommand.setData(consulta.getDataConsulta());
        consultaCommand.setEstado(consulta.getEstado());
        consultaCommand.setDescricao(consulta.getDescricao());
        return consultaCommand;
    }

}
