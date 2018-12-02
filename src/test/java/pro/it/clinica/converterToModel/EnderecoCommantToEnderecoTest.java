package pro.it.clinica.converterToModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.Command.EnderecoCommand;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.model.padrao.Endereco;

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

    @Component
    public static class ConsultaCommandToConsulta implements Converter<ConsultaCommand,Consulta> {

        @Override
        public Consulta convert(ConsultaCommand consultaCommand) {
            if( consultaCommand == null )
                return null;
            Consulta consulta = new Consulta();
            consulta.setId(consultaCommand.getId());
            consulta.setDataConsulta(consultaCommand.getDataConsulta());
            consulta.setDataActual(consultaCommand.getDataHoje());
            consulta.setEstado(consultaCommand.getEstado());
            consulta.setDescricao(consultaCommand.getDescricao());
            return consulta;
        }

    }
}
