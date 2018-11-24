package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.converter.PacienteCommandToPaciente;
import pro.it.clinica.converter.PacienteToPacienteCommand;
import pro.it.clinica.model.Paciente;
import pro.it.clinica.repository.PacienteRepositorio;
import pro.it.clinica.service.ServicePaciente;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements ServicePaciente {

    private PacienteRepositorio pacienteRepositorio;
    private PacienteCommandToPaciente pacienteCommandToPaciente;
    private PacienteToPacienteCommand pacienteToPacienteCommand;
    private NacionalidadeServiceImpl nacionalidadeService;

    public PacienteServiceImpl(PacienteRepositorio pacienteRepositorio, PacienteCommandToPaciente pacienteCommandToPaciente, PacienteToPacienteCommand pacienteToPacienteCommand, NacionalidadeServiceImpl nacionalidadeService) {
        this.pacienteRepositorio = pacienteRepositorio;
        this.pacienteCommandToPaciente = pacienteCommandToPaciente;
        this.pacienteToPacienteCommand = pacienteToPacienteCommand;
        this.nacionalidadeService = nacionalidadeService;
    }

    @Override
    public PacienteCommand novo(PacienteCommand pacienteCommand) {
        Set<NacionalidadeCommand> nacionalidadeSet = nacionalidadeService
                    .validacao(pacienteCommand.getNacionalidades());
        pacienteCommand.setNacionalidades(nacionalidadeSet);
        Paciente novo = pacienteCommandToPaciente.convert(pacienteCommand);
        Paciente novoPaciente = pacienteRepositorio.save(novo);
        return pacienteToPacienteCommand.convert(novoPaciente);
    }

    @Override
    public List<PacienteCommand> listar() {
        return  pacienteRepositorio.findAll()
                .stream()
                .map(pacienteToPacienteCommand::convert)
                .collect(Collectors.toList());
    }


    @Override
    public PacienteCommand pesquisarId(Long id) {
       Optional<Paciente> pacienteOptinal = pacienteRepositorio.findById(id);
       PacienteCommand pacienteCommand = pacienteToPacienteCommand.convert(pacienteOptinal.orElse(null));
       return pacienteCommand;
    }

}
