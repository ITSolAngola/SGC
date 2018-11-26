package pro.it.clinica.service;

import pro.it.clinica.Command.FuncionarioCommand;
import pro.it.clinica.model.Funcionario;

public interface ServiceFuncionario extends ServiceGenerico<FuncionarioCommand> {
    Funcionario get(FuncionarioCommand funcionarioCommand);
    Funcionario saveGet(FuncionarioCommand funcionarioCommand);
}
