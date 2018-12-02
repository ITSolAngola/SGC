package pro.it.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.it.clinica.model.Fatura;

public interface FaturaRepositorio extends JpaRepository<Fatura,Long> {
}
