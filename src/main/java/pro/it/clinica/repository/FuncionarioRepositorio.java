package pro.it.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.it.clinica.model.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario,Long> {
}
