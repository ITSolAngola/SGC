package pro.it.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.it.clinica.model.Paciente;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente,Long> {
}
