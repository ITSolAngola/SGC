package pro.it.gestao_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.it.gestao_clinica.model.Paciente;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente,Long> {
}
