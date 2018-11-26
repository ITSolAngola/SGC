package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.MedicoEspecialidade;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MedicoCommandToMedico implements Converter<MedicoCommand,Funcionario> {

    private EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade;
    private FuncionarioCommantToFuncionario funcionarioCommantToFuncionario;
    private NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade;


    public MedicoCommandToMedico(EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade,
                                 FuncionarioCommantToFuncionario funcionarioCommantToFuncionario, NacionalidadeCommandToNacionalidade nacionalidadeCommandToNacionalidade) {
        this.especialidadeCommandToEspecialidade = especialidadeCommandToEspecialidade;
        this.funcionarioCommantToFuncionario = funcionarioCommantToFuncionario;
        this.nacionalidadeCommandToNacionalidade = nacionalidadeCommandToNacionalidade;
    }

    @Override
    public Funcionario convert(MedicoCommand medicoCommand) {
        Funcionario funcionario = funcionarioCommantToFuncionario.convert(medicoCommand);
        Set<MedicoEspecialidade> medicoEspecialidadeSet = medicoCommand
                .getEspecialidades()
                .stream()
                .map(especialidadeCommandToEspecialidade::convert)
                .map( especialidade ->{
                    MedicoEspecialidade medicoEspecialidade =
                            new MedicoEspecialidade(funcionario,especialidade);
                    return medicoEspecialidade;
                })
                .collect(Collectors.toSet());

        funcionario.setMedicoEspecialidades(medicoEspecialidadeSet);
        System.out.println( "Lista de ESPECIALIDADES : " + medicoCommand.getEspecialidades().size());
        System.out.println( "Lista de ESPECIALIDADES RETORNADAS : " + medicoEspecialidadeSet.size());
        funcionario.setNacionalidades(
                medicoCommand.getNacionalidades()
                            .stream()
                            .map(nacionalidadeCommandToNacionalidade::convert)
                            .collect(Collectors.toSet()));
        return funcionario;
    }


}
