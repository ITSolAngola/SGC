package pro.it.gestao_clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pro.it.gestao_clinica.Command.NacionalidadeCommand;
import pro.it.gestao_clinica.converter.NacionalidadeCommandToNacionalidade;
import pro.it.gestao_clinica.converter.NacionalidadeToNacionalidadeCommand;
import pro.it.gestao_clinica.model.Nacionalidade;
import pro.it.gestao_clinica.repository.NacionalidadeRepositorio;
import pro.it.gestao_clinica.serviceImpl.NacionalidadeServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class NacionalidadeServiceImplTest  {

    @Mock
    private NacionalidadeRepositorio nacionalidadeRepositorio;

    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    private NacionalidadeServiceImpl nacionalidadeService;

    @Before
    public void init(){

        nacionalidadeCommandToNacionalidade = new NacionalidadeCommandToNacionalidade();
        nacionalidadeToNacionalidadeCommand = new NacionalidadeToNacionalidadeCommand();

        nacionalidadeService = new NacionalidadeServiceImpl(
                nacionalidadeToNacionalidadeCommand,
                nacionalidadeCommandToNacionalidade);

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void adicionarTest(){
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais("Angola");
        nacionalidadeCommand.setId(1L);

        when( nacionalidadeRepositorio.save(Mockito.any(Nacionalidade.class)))
                .thenReturn(nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand));

        NacionalidadeCommand nacionalidadeNovo = nacionalidadeService.adicionar(nacionalidadeCommand);
        Assert.assertEquals(nacionalidadeCommand.getId(),nacionalidadeNovo.getId());
    }

    @Test
    public void pesquisarTest(){
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais("Angola");
        nacionalidadeCommand.setId(1L);

        Optional<Nacionalidade> optionalNacionalidade = Optional.of( nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand) );

        when( nacionalidadeRepositorio.findByPais(Mockito.anyString()))
                .thenReturn(optionalNacionalidade);

        NacionalidadeCommand nacionalidadeNovo = nacionalidadeService.pesquisar("Angola");
        Assert.assertNull(nacionalidadeNovo);
    }


}
