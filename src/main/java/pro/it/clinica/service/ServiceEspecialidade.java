package pro.it.clinica.service;

import pro.it.clinica.Command.EspecialidadeCommand;

import java.util.List;
import java.util.Set;

public interface ServiceEspecialidade {
    EspecialidadeCommand novo( EspecialidadeCommand especialidadeCommand);
    List<EspecialidadeCommand> listar();
    EspecialidadeCommand editar(EspecialidadeCommand especialidadeCommand);
}
