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
        when(especialidadeRepositorio.save(Mockito.any(Especialidade.class)))
                .thenReturn(especialidade);

        EspecialidadeCommand especialidadeCommand1 = especialidadeServiceImpl.novo(especialidadeCommand);

        Assert.assertEquals(especialidadeCommand1.getId(),especialidadeCommand.getId());
    }

}
