package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.converter.NacionalidadeCommandToNacionalidade;
import pro.it.clinica.converter.NacionalidadeToNacionalidadeCommand;
import pro.it.clinica.model.Nacionalidade;
import pro.it.clinica.repository.NacionalidadeRepositorio;
import pro.it.clinica.service.ServiceNacionalidade;

import java.util.HashSet;
import java.util.Set;

@Service
public class NacionalidadeServiceImpl implements ServiceNacionalidade {

     private NacionalidadeRepositorio nacionalidadeRepositorio;

    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    public NacionalidadeServiceImpl(NacionalidadeRepositorio nacionalidadeRepositorio,
                                    NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand,
                                    NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade) {
        this.nacionalidadeRepositorio = nacionalidadeRepositorio;
        this.nacionalidadeToNacionalidadeCommand = nacionalidadeToNacionalidadeCommand;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
    }

    @Override
    public NacionalidadeCommand adicionar(NacionalidadeCommand nacionalidadeCommand) {
        Nacionalidade nacionalidade = nacionalidadeRepositorio.save(nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand));
        return (nacionalidade!=null)?nacionalidadeToNacionalidadeCommand.convert( nacionalidade ):null;
    }

    @Override
    public NacionalidadeCommand pesquisar(String pais) {
        Nacionalidade nacionalidade = nacionalidadeRepositorio.findByPais(pais);
        return (nacionalidade!=null)?nacionalidadeToNacionalidadeCommand.convert( nacionalidade ):null;
    }

    @Override
    public Set<NacionalidadeCommand> validacao(Set<NacionalidadeCommand> nacionalidadeCommands) {
        Set<NacionalidadeCommand> nacionalidadeCommandsSet = new HashSet<>();

        for (NacionalidadeCommand nacionalidadeCommand : nacionalidadeCommands ){
             NacionalidadeCommand resultado = pesquisar(nacionalidadeCommand.getPais());
             if( resultado == null ){
                 resultado = adicionar(nacionalidadeCommand);
             }
            nacionalidadeCommandsSet.add(resultado);
         }
         return nacionalidadeCommandsSet;
    }

}
