package pro.it.gestao_clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.Command.ConsultaCommand;
import pro.it.gestao_clinica.model.Consulta;
@Component
public class ConsultaToConsultaCommand implements Converter<Consulta,ConsultaCommand> {
    @Override
    public ConsultaCommand convert(Consulta consulta) {
        ConsultaCommand consultaCommand = new ConsultaCommand();
        consultaCommand.setId(consulta.getId());
        consultaCommand.setDataConsulta(consulta.getDataConsulta());
        consultaCommand.setDataActual(consulta.getDataConsulta());
        consultaCommand.setEstado(consulta.getEstado());
        return consultaCommand;
    }

}
