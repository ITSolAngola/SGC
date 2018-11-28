package pro.it.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.it.clinica.model.Consulta;

public interface ConsultaRepositorio extends JpaRepository<Consulta,Long> {
}
