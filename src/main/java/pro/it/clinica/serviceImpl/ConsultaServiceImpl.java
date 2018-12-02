package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Component;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.bootstrap.EstadoConsulta;
import pro.it.clinica.converterToCommand.ConsultaToConsultaCommand;
import pro.it.clinica.converterToModel.ConsultaCommandToConsulta;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.repository.ConsultaRepositorio;
import pro.it.clinica.service.ServiceConsulta;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsultaServiceImpl implements ServiceConsulta {

    private ConsultaRepositorio consultaRepositorio;
    private ConsultaCommandToConsulta consultaCommandToConsulta;
    private ConsultaToConsultaCommand consultaToConsultaCommand;

    public ConsultaServiceImpl(ConsultaRepositorio consultaRepositorio, ConsultaCommandToConsulta consultaCommandToConsulta, ConsultaToConsultaCommand consultaToConsultaCommand) {
        this.consultaRepositorio = consultaRepositorio;
        this.consultaCommandToConsulta = consultaCommandToConsulta;
        this.consultaToConsultaCommand = consultaToConsultaCommand;
    }

    @Override
    public Consulta get(ConsultaCommand consultaCommand) {
        return consultaCommandToConsulta.convert(consultaCommand);
    }

    @Override
    public ConsultaCommand cadastrar(Consulta consulta) {
        consulta.setEstado(EstadoConsulta.FAZER);
        return consultaToConsultaCommand
                .convert(consultaRepositorio.save(consulta));
    }

    @Override
    public ConsultaCommand novo(ConsultaCommand consultaCommand) {
        return null;
    }

    @Override
    public List<ConsultaCommand> listar() {
        return consultaRepositorio.findAll().stream().map(consultaToConsultaCommand::convert)
                                                    .collect(Collectors.toList());
    }

    @Override
    public ConsultaCommand pesquisarId(Long id) {
        return consultaRepositorio.findById(id).map(consultaToConsultaCommand::convert).get();
    }

}
