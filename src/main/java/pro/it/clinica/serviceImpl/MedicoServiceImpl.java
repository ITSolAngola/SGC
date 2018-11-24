package pro.it.clinica.serviceImpl;

import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.converter.EspecialidadeCommandToEspecialidade;
import pro.it.clinica.converter.FuncionarioCommantToFuncionario;
import pro.it.clinica.model.Especialidade;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.MedicoEspecialidade;
import pro.it.clinica.service.ServiceMedico;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MedicoServiceImpl implements ServiceMedico{

    private FuncionarioCommantToFuncionario funcionarioCommantToFuncionario;
    private EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade;

    public MedicoServiceImpl(FuncionarioCommantToFuncionario funcionarioCommantToFuncionario, EspecialidadeCommandToEspecialidade especialidadeCommandToEspecialidade) {
        this.funcionarioCommantToFuncionario = funcionarioCommantToFuncionario;
        this.especialidadeCommandToEspecialidade = especialidadeCommandToEspecialidade;
    }


    @Override
    public MedicoCommand novo(MedicoCommand medicoCommand) {
        Funcionario funcionario = funcionarioCommantToFuncionario.convert(medicoCommand);
        Set<Especialidade> especialidades = medicoCommand.getEspecialidadeCommands()
                                                        .stream()
                                                        .map(especialidadeCommandToEspecialidade::convert)
                                                        .collect(Collectors.toSet());

        MedicoEspecialidade medicoEspecialidade = new MedicoEspecialidade();
       return medicoCommand;
    }

    @Override
    public List<MedicoCommand> listar() {
        return null;
    }

    @Override
    public MedicoCommand pesquisarId(Long id) {
        return null;
    }
}
