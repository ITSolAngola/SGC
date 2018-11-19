package pro.it.gestao_clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.gestao_clinica.Command.EnderecoCommand;
import pro.it.gestao_clinica.model.padrao.Endereco;

public class EnderecoCommantToEnderecoTest {

    private EnderecoCommandToEndereco enderecoCommandToEndereco;

    @Before
    public void init(){
        enderecoCommandToEndereco = new EnderecoCommandToEndereco();
    }

    @Test
    public void converterTes(){
        EnderecoCommand enderecoCommand = new EnderecoCommand();

        enderecoCommand.setMunicipio("Viana");
        enderecoCommand.setRua("Vila nova");
        enderecoCommand.setNumeroCasa("230");
        enderecoCommand.setBairro("Nova landia");
        enderecoCommand.setCidade("Luanda");
        enderecoCommand.setPais("Angola");

        Endereco endereco =enderecoCommandToEndereco.convert(enderecoCommand);

        System.out.println(endereco);

        Assert.assertTrue(endereco.getCidade().equals(enderecoCommand.getCidade()));
        Assert.assertTrue(endereco.getnCasa().equals(enderecoCommand.getNumeroCasa()));
    }

}
