package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.Command.NacionalidadeCommand;
import pro.it.clinica.converter.MedicoCommandToMedico;
import pro.it.clinica.converter.MedicoToMedicoCommand;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.repository.FuncionarioRepositorio;
import pro.it.clinica.service.ServiceMedico;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements ServiceMedico{

    private FuncionarioRepositorio funcionarioRepositorio;
    private MedicoCommandToMedico medicoCommandToMedico;
    private MedicoToMedicoCommand medicoToMedicoCommand;

    public MedicoServiceImpl(FuncionarioRepositorio funcionarioRepositorio, MedicoCommandToMedico medicoCommandToMedico, MedicoToMedicoCommand medicoToMedicoCommand) {
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.medicoCommandToMedico = medicoCommandToMedico;
        this.medicoToMedicoCommand = medicoToMedicoCommand;
    }

    @Transactional
    @Override
    public MedicoCommand novo( MedicoCommand medicoCommand ) {
        Funcionario funcionario = medicoCommandToMedico.convert(medicoCommand);
        MedicoCommand medicoCommand1 = medicoToMedicoCommand.convert(funcionarioRepositorio.save(funcionario));
        return medicoCommand1;
    }

    @Override
    public List<MedicoCommand> listar() {
        return funcionarioRepositorio
                .findAll()
                .stream()
                .filter(funcionario -> funcionario.getMedicoEspecialidades().size()>0)
                .map(medicoToMedicoCommand::convert)
                .collect(Collectors.toList());
    }

    @Override
    public MedicoCommand pesquisarId(Long id) {
        return funcionarioRepositorio.findById(id).map(medicoToMedicoCommand::convert).get();
    }

}
