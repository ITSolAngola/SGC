package pro.it.clinica.service;

import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.model.Nacionalidade;

import java.util.Set;

public interface ServiceNacionalidade extends ServiceGenerico<NacionalidadeCommand> {
    NacionalidadeCommand pesquisar(String pais);
    NacionalidadeCommand validacao(NacionalidadeCommand nacionalidadeCommand);
    Nacionalidade get(NacionalidadeCommand nacionalidadeCommand);
    Set<NacionalidadeCommand> validaSet(Set<NacionalidadeCommand> nacionalidadeCommandSet);
}
