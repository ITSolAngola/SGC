package pro.it.gestao_clinica.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import pro.it.gestao_clinica.Command.NacionalidadeCommand;
import pro.it.gestao_clinica.converter.NacionalidadeCommandToNacionalidade;
import pro.it.gestao_clinica.converter.NacionalidadeToNacionalidadeCommand;
import pro.it.gestao_clinica.model.Nacionalidade;
import pro.it.gestao_clinica.repository.NacionalidadeRepositorio;
import pro.it.gestao_clinica.service.ServiceNacionalidade;

import java.util.Optional;

public class NacionalidadeServiceImpl implements ServiceNacionalidade {

    @Autowired
    private NacionalidadeRepositorio nacionalidadeRepositorio;

    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    public NacionalidadeServiceImpl( NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand, NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade) {
        this.nacionalidadeToNacionalidadeCommand = nacionalidadeToNacionalidadeCommand;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
    }

    @Override
    public NacionalidadeCommand adicionar(NacionalidadeCommand nacionalidadeCommand) {
        Nacionalidade nacionalidade = nacionalidadeRepositorio.save(nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand));
        return nacionalidadeToNacionalidadeCommand.convert( nacionalidade );
    }

    @Override
    public NacionalidadeCommand pesquisar(String pais) {
        Optional<Nacionalidade> nacionalidade = nacionalidadeRepositorio.findByPais(pais);
        return nacionalidadeToNacionalidadeCommand.convert(nacionalidade.get());
    }


}
