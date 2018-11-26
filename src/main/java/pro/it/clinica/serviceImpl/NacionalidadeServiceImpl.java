package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.converter.NacionalidadeCommandToNacionalidade;
import pro.it.clinica.converter.NacionalidadeToNacionalidadeCommand;
import pro.it.clinica.model.Nacionalidade;
import pro.it.clinica.repository.NacionalidadeRepositorio;
import pro.it.clinica.service.ServiceNacionalidade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public NacionalidadeCommand novo(NacionalidadeCommand nacionalidadeCommand) {
        Nacionalidade nacionalidade = nacionalidadeRepositorio.save(nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand));
        return (nacionalidade!=null)?nacionalidadeToNacionalidadeCommand.convert( nacionalidade ):null;
    }

    @Override
    public NacionalidadeCommand pesquisar(String pais) {
        Nacionalidade nacionalidade = nacionalidadeRepositorio.findByPais(pais);
        return (nacionalidade!=null)?nacionalidadeToNacionalidadeCommand.convert( nacionalidade ):null;
    }

    @Override
    public NacionalidadeCommand validacao(NacionalidadeCommand nacionalidadeCommand) {
        NacionalidadeCommand resultado = pesquisar(nacionalidadeCommand.getPais());
        if( resultado == null ){
            resultado = novo(nacionalidadeCommand);
        }
         return resultado;
    }

    @Override
    public Nacionalidade get(NacionalidadeCommand nacionalidadeCommand) {
        return nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand);
    }

    @Override
    public Set<NacionalidadeCommand> validaSet(Set<NacionalidadeCommand> nacionalidadeCommandSet) {
        return nacionalidadeCommandSet.stream()
                .map(nacionalidadeCommand -> validacao(nacionalidadeCommand))
                .collect(Collectors.toSet());
    }

    @Override
    public List<NacionalidadeCommand> listar() {
        return null;
    }

    @Override
    public NacionalidadeCommand pesquisarId(Long id) {
        return null;
    }
}
