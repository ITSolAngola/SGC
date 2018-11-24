package pro.it.clinica.service;

import pro.it.clinica.Command.NacionalidadeCommand;

import java.util.Set;

public interface ServiceNacionalidade extends ServiceGenerico<NacionalidadeCommand> {
    NacionalidadeCommand pesquisar(String pais);
    Set<NacionalidadeCommand> validacao(Set<NacionalidadeCommand> nacionalidadeCommands);

}
