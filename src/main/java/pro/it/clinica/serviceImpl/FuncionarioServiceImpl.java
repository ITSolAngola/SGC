package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Service;
import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.converter.FuncionarioCommantToFuncionario;
import pro.it.clinica.converter.FuncionarioToFuncionarioCommand;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.repository.FuncionarioRepositorio;
import pro.it.clinica.service.ServiceFuncionario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements ServiceFuncionario {

    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioCommantToFuncionario funcionarioCommantToFuncionario;
    private FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand;

    public FuncionarioServiceImpl(FuncionarioRepositorio funcionarioRepositorio, FuncionarioCommantToFuncionario funcionarioCommantToFuncionario, FuncionarioToFuncionarioCommand funcionarioToFuncionarioCommand) {
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioCommantToFuncionario = funcionarioCommantToFuncionario;
        this.funcionarioToFuncionarioCommand = funcionarioToFuncionarioCommand;
    }

    @Override
    public FuncionarioCommand novo(FuncionarioCommand funcionarioCommand) {
        Funcionario novoFuncioario = funcionarioRepositorio.save(funcionarioCommantToFuncionario.convert(funcionarioCommand));
        FuncionarioCommand funcionarioCommand1 = funcionarioToFuncionarioCommand.convert(novoFuncioario);
        return funcionarioCommand1;
    }

    @Override
    public List<FuncionarioCommand> listar() {
        return funcionarioRepositorio.findAll()
                    .stream()
                    .map(funcionarioToFuncionarioCommand::convert)
                    .collect(Collectors.toList());
    }

    @Override
    public FuncionarioCommand pesquisarId(Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepositorio.findById(id);
        return optionalFuncionario.map(funcionarioToFuncionarioCommand::convert)
                                 .orElse(null);
    }

    @Override
    public Funcionario get(FuncionarioCommand funcionarioCommand) {
        return funcionarioCommantToFuncionario.convert(funcionarioCommand);
    }

    @Override
    public Funcionario saveGet(FuncionarioCommand funcionarioCommand) {
        return get( novo(funcionarioCommand) );
    }
}
