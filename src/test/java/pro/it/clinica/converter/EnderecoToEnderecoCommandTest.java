package pro.it.clinica.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.model.padrao.Endereco;

public class EnderecoToEnderecoCommandTest {

    private EnderecoToEnderecoCommand enderecoToEnderecoCommand;

    @Before
    public void init(){
        enderecoToEnderecoCommand = new EnderecoToEnderecoCommand();
    }

    @Test
    public void converterTes(){
        Endereco endereco= new Endereco();

        endereco.setMuinicipio("Viana");
        endereco.setnCasa("230");
        endereco.setBairro("Nova landia");
        endereco.setCidade("Luanda");
        endereco.setPais("Angola");
        endereco.setRua("Vila nova");

        EnderecoCommand enderecoCommand = enderecoToEnderecoCommand.convert(endereco);

        System.out.println(endereco);

        Assert.assertTrue(endereco.getCidade().equals(enderecoCommand.getCidade()));
        Assert.assertTrue(endereco.getnCasa().equals(enderecoCommand.getNumeroCasa()));
    }


}
