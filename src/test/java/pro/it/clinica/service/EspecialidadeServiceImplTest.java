package pro.it.clinica.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.converter.EspecialidadeCommandToEspecialidade;
import pro.it.clinica.converter.EspecialidadeToEspecialidadeCommand;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.repository.EspecialidadeRepositorio;
import pro.it.clinica.serviceImpl.EspecialidadeServiceImpl;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EspecialidadeServiceImplTest  {

    @Mock
    private EspecialidadeRepositorio especialidadeRepositorio;
    private EspecialidadeServiceImpl especialidadeServiceImpl;

    private EspecialidadeToEspecialidadeCommand especialidadeToEspecialidadeCommand;
    private EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        especialidadeToEspecialidadeCommand = new EspecialidadeToEspecialidadeCommand();
        especialidadeCommandToEspecialidade = new EspecialidadeCommandToEspecialidade();

        especialidadeServiceImpl = new EspecialidadeServiceImpl(especialidadeRepositorio,
                                                                 especialidadeCommandToEspecialidade,
                                                                especialidadeToEspecialidadeCommand);


    }

    @Test
    public void novoTest(){
        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand();
        especialidadeCommand.setId(1L);
        especialidadeCommand.setNome("Esaldino");
        especialidadeCommand.setPreco(36.0);

        Especialidade especialidade = especialidadeCommandToEspecialidade.convert(especialidadeCommand);
        when(especialidadeRepositorio.save(any(Especialidade.class)))
                .thenReturn(especialidade);

        EspecialidadeCommand especialidadeCommand1 = especialidadeServiceImpl.novo(especialidadeCommand);

        Assert.assertEquals(especialidadeCommand1.getId(),especialidadeCommand.getId());
    }

    @Test
    public void pequisarIdTest(){
        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand();
        especialidadeCommand.setId(1L);
        especialidadeCommand.setNome("Coloproctologia");
        especialidadeCommand.setPreco(52000D);

        Especialidade especialidade = especialidadeCommandToEspecialidade.convert(especialidadeCommand);

        when(especialidadeRepositorio.findById(anyLong())).thenReturn(Optional.of( especialidade ) );

        EspecialidadeCommand ec = especialidadeServiceImpl.pesquisarId(1L);


        Assert.assertEquals(ec.getId(),especialidadeCommand.getId());
        verify(especialidadeRepositorio,Mockito.times(1)).findById(anyLong());
    }

    @Test
    public void validaTest() {

        Especialidade especialidade = new Especialidade();
        especialidade.setId(1L);
        especialidade.setNome("Esaldino");
        especialidade.setPreco(2D);

        EspecialidadeCommand especialidadeCommand1 = especialidadeToEspecialidadeCommand.convert(especialidade);

        when(especialidadeRepositorio.findByNome(anyString())).thenReturn(null);
        when(especialidadeRepositorio.save(any(Especialidade.class))).thenReturn(especialidade);

        EspecialidadeCommand EspecialidadeValidade = especialidadeServiceImpl.valida(especialidadeCommand1);

        Assert.assertNotNull(EspecialidadeValidade);

        verify(especialidadeRepositorio,Mockito.times(1))
                .save(any(Especialidade.class));

    }

    /*
    @Override
    public Especialidade get(EspecialidadeCommand especialidadeCommand) {
        return especialidadeCommandToEspecialidade.convert(especialidadeCommand);
    }

    @Override
    public Especialidade validaGet(EspecialidadeCommand especialidadeCommand) {
        return especialidadeCommandToEspecialidade.convert(valida(especialidadeCommand));
    }
    */
}
