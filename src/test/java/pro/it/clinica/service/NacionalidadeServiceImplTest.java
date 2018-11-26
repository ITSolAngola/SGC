package pro.it.clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.converter.NacionalidadeCommandToNacionalidade;
import pro.it.clinica.converter.NacionalidadeToNacionalidadeCommand;
import pro.it.clinica.model.Nacionalidade;
import pro.it.clinica.repository.NacionalidadeRepositorio;
import pro.it.clinica.serviceImpl.NacionalidadeServiceImpl;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class NacionalidadeServiceImplTest  {

    @Mock
    private NacionalidadeRepositorio nacionalidadeRepositorio;

    @InjectMocks
    private NacionalidadeToNacionalidadeCommand nacionalidadeToNacionalidadeCommand;
    @InjectMocks
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;

    private NacionalidadeServiceImpl nacionalidadeService;

    @Before
    public void init(){

        MockitoAnnotations.initMocks(this);

        nacionalidadeService = new NacionalidadeServiceImpl(
                nacionalidadeRepositorio, nacionalidadeToNacionalidadeCommand,
                nacionalidadeCommandToNacionalidade);


    }

    @Test
    public void adicionarTest(){
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais("Angola");
        nacionalidadeCommand.setId(1L);

        when( nacionalidadeRepositorio.save(Mockito.any(Nacionalidade.class)))
                .thenReturn(nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand));

        NacionalidadeCommand nacionalidadeNovo = nacionalidadeService.novo(nacionalidadeCommand);
        Assert.assertEquals(nacionalidadeCommand.getId(),nacionalidadeNovo.getId());
    }

    @Test
    public void pesquisarTest(){
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais("Angola");
        nacionalidadeCommand.setId(1L);

        Nacionalidade optionalNacionalidade = nacionalidadeCommandToNacionalidade.convert(nacionalidadeCommand);

        when( nacionalidadeRepositorio.findByPais(Mockito.anyString()))
                .thenReturn(optionalNacionalidade);

        NacionalidadeCommand nacionalidadeNovo = nacionalidadeService.pesquisar("Angola");
        Assert.assertNotNull(nacionalidadeNovo);
    }



    @Test
    public void validacaoPesquisarTest(){

        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais("Angola");
        nacionalidadeCommand.setId(1L);

        Nacionalidade nacionalidade = nacionalidadeCommandToNacionalidade
                                                    .convert(nacionalidadeCommand);
        Nacionalidade nacionalidade1 = nacionalidadeCommandToNacionalidade
                                                            .convert(nacionalidadeCommand);

       when(nacionalidadeRepositorio.findByPais(anyString()))
                .thenReturn( nacionalidade,nacionalidade1);

        NacionalidadeCommand novaLista = nacionalidadeService.validacao(nacionalidadeCommand);

        Assert.assertEquals(nacionalidadeCommand.getId(),novaLista.getId());
        verify(nacionalidadeRepositorio,Mockito.times(1)).findByPais(anyString());
    }

    @Test
    public void validacaoAdicionarTest(){
        NacionalidadeCommand nacionalidadeCommand = new NacionalidadeCommand();
        nacionalidadeCommand.setPais("Angola");
        nacionalidadeCommand.setId(1L);


        Nacionalidade nacionalidade = nacionalidadeCommandToNacionalidade
                .convert(nacionalidadeCommand);

        when(nacionalidadeRepositorio.findByPais(anyString()))
                .thenReturn( null);
        when(nacionalidadeRepositorio.save(any(Nacionalidade.class)))
                .thenReturn( nacionalidade);

        NacionalidadeCommand novaLista = nacionalidadeService.validacao(nacionalidadeCommand);

        Assert.assertEquals(nacionalidadeCommand.getId(),novaLista.getId());
        verify(nacionalidadeRepositorio,Mockito.times(1)).save(any(Nacionalidade.class));
    }


}
