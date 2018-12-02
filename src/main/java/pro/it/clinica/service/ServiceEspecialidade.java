package pro.it.clinica.service;

import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.model.Especialidade;

import java.util.Set;


public interface ServiceEspecialidade extends ServiceGenerico<EspecialidadeCommand,Especialidade>{
    EspecialidadeCommand valida(EspecialidadeCommand especialidadeCommand);
    Set<EspecialidadeCommand> validaList(Set<EspecialidadeCommand> especialidadeCommandSet);
    EspecialidadeCommand pesquisarNome(String nome);
}
