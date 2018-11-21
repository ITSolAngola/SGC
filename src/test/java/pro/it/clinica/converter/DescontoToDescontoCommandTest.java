package pro.it.clinica.converter;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.DescontoCommand;
import pro.it.clinica.model.Desconto;

public class DescontoToDescontoCommandTest {
    private DescontoToDescontoCommand descontoToDescontoCommand;

    @Before
    public void init(){
        descontoToDescontoCommand = new DescontoToDescontoCommand();
    }

    @Test
    public void converterTest(){
        Desconto desconto = new Desconto();
        desconto.setValor(1.0);
        desconto.setLimite(1);
        desconto.setDescricao("Boas festas");

        DescontoCommand descontoCommand = descontoToDescontoCommand.convert(desconto);
        Assert.assertEquals(descontoCommand.getId(),desconto.getId());
    }
}
