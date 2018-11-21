package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.converter.EspecialidadeCommandToEspecialidade;
import pro.it.clinica.converter.EspecialidadeToEspecialidadeCommand;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.repository.EspecialidadeRepositorio;
import pro.it.clinica.service.ServiceEspecialidade;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadeServiceImpl implements ServiceEspecialidade {

    private EspecialidadeRepositorio especialidadeRepositorio;
    private EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade;
    private EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand;

    public EspecialidadeServiceImpl(EspecialidadeRepositorio especialidadeRepositorio,
                                    EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade,
                                    EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand) {
        this.especialidadeRepositorio = especialidadeRepositorio;
        this.especialidadeCommandToEspecialidade = especialidadeCommandToEspecialidade;
        this.especialidadeToEspecialidadeCommand = especialidadeToEspecialidadeCommand;
    }

    @Override
    public EspecialidadeCommand novo( EspecialidadeCommand especialidadeCommand ) {
        Especialidade especialidade = especialidadeCommandToEspecialidade
                                                        .convert(especialidadeCommand);
        return  especialidadeToEspecialidadeCommand
                                    .convert(especialidadeRepositorio.save(especialidade));
    }

    @Override
    public EspecialidadeCommand editar(EspecialidadeCommand especialidadeCommand) {
        return null;
    }

    @Override
    public List<EspecialidadeCommand> listar() {
        return especialidadeRepositorio.findAll()
                                        .stream()
                                        .map(especialidadeToEspecialidadeCommand::convert)
                                        .collect(Collectors.toList());
    }
}
