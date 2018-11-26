package pro.it.clinica.serviceImpl;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.converter.EspecialidadeCommandToEspecialidade;
import pro.it.clinica.converter.EspecialidadeToEspecialidadeCommand;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.repository.EspecialidadeRepositorio;
import pro.it.clinica.service.ServiceEspecialidade;

import java.util.List;
import java.util.Optional;
import java.util.Set;
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

    @Nullable
    @Override
    public EspecialidadeCommand pesquisarId( Long id ) {
        EspecialidadeCommand especialidadeCommand = null;
        Optional<Especialidade> especialidadeOptional = especialidadeRepositorio.findById(id);
        if (especialidadeOptional != null ) {
            especialidadeCommand = especialidadeToEspecialidadeCommand.convert(especialidadeOptional.get());
            return especialidadeCommand;
        }
        return null;
    }

    @Override
    public List<EspecialidadeCommand> listar() {
        return especialidadeRepositorio.findAll()
                                        .stream()
                                        .map(especialidadeToEspecialidadeCommand::convert)
                                        .collect(Collectors.toList());
    }

    @Override
    public EspecialidadeCommand valida(EspecialidadeCommand especialidadeCommand) {

        EspecialidadeCommand especialidadePesquisada =  pesquisarNome(especialidadeCommand.getNome());
        if( especialidadePesquisada == null ){
            especialidadePesquisada = novo(especialidadeCommand);
        }

        return especialidadePesquisada;
    }


    @Override
    public EspecialidadeCommand pesquisarNome(String nome) {
        Especialidade especialidade = especialidadeRepositorio.findByNome(nome);
        return especialidadeToEspecialidadeCommand.convert( especialidade );
    }

    @Override
    public Set<EspecialidadeCommand> validaList(Set<EspecialidadeCommand> especialidadeCommandSet) {
        return especialidadeCommandSet
                .stream()
                .map(especialidadeCommand -> valida(especialidadeCommand))
                .collect(Collectors.toSet());
    }
}
