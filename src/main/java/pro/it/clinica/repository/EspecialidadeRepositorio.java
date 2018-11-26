package pro.it.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.it.clinica.model.Especialidade;

public interface EspecialidadeRepositorio extends JpaRepository<Especialidade,Long> {
    Especialidade findByNome(String nome);
}
