package pro.it.clinica.converterToModel;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.model.Funcionario;

import java.util.stream.Collectors;

@Component
public class MedicoCommandToMedico implements Converter<MedicoCommand,Funcionario> {

    private EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade;
    private FuncionarioCommantToFuncionario funcionarioCommantToFuncionario;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;
    private ConsultaCommandToConsulta consultaCommandToConsulta;


    public MedicoCommandToMedico(EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade,
                                 FuncionarioCommantToFuncionario funcionarioCommantToFuncionario, NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade, ConsultaCommandToConsulta consultaCommandToConsulta) {
        this.especialidadeCommandToEspecialidade = especialidadeCommandToEspecialidade;
        this.funcionarioCommantToFuncionario = funcionarioCommantToFuncionario;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
        this.consultaCommandToConsulta = consultaCommandToConsulta;
    }

    @Override
    public Funcionario convert(MedicoCommand medicoCommand) {
        Funcionario funcionario = funcionarioCommantToFuncionario.convert(medicoCommand);
        funcionario.setNacionalidades(
                medicoCommand.getNacionalidades()
                            .stream()
                            .map(nacionalidadeCommandToNacionalidade::convert)
                            .collect(Collectors.toSet()));

        funcionario.setEspecialidades(
                medicoCommand.getEspecialidades()
                        .stream()
                        .map(especialidadeCommandToEspecialidade::convert)
                        .collect(Collectors.toSet()));

        funcionario.setConsultas(medicoCommand.getConsultas()
                                            .stream()
                                            .map(consultaCommandToConsulta::convert)
                                            .collect(Collectors.toSet()));

        return funcionario;
    }


}
