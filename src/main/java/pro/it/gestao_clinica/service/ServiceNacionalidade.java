package pro.it.gestao_clinica.service;

import pro.it.gestao_clinica.Command.NacionalidadeCommand;
import pro.it.gestao_clinica.model.Nacionalidade;

public interface ServiceNacionalidade {

    NacionalidadeCommand adicionar(NacionalidadeCommand nacionalidadeCommand);
    NacionalidadeCommand pesquisar(String pais);

}
