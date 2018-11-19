package pro.it.gestao_clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.converter.PacienteCommandToPaciente;
import pro.it.gestao_clinica.converter.PacienteToPacienteCommand;
import pro.it.gestao_clinica.model.Paciente;
import pro.it.gestao_clinica.repository.PacienteRepositorio;
import pro.it.gestao_clinica.service.ServicePaciente;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements ServicePaciente {

    private PacienteRepositorio pacienteRepositorio;
    private PacienteCommandToPaciente pacienteCommandToPaciente;
    private PacienteToPacienteCommand pacienteToPacienteCommand;

    public PacienteServiceImpl(PacienteRepositorio pacienteRepositorio, PacienteCommandToPaciente pacienteCommandToPaciente, PacienteToPacienteCommand pacienteToPacienteCommand) {
        this.pacienteRepositorio = pacienteRepositorio;
        this.pacienteCommandToPaciente = pacienteCommandToPaciente;
        this.pacienteToPacienteCommand = pacienteToPacienteCommand;
    }

    @Override
    public PacienteCommand adicionar(PacienteCommand pacienteCommand) {
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
    public PacienteCommand editar(PacienteCommand paciente) {
        return null;
    }
}
