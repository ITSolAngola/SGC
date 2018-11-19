package pro.it.gestao_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.it.gestao_clinica.model.Nacionalidade;

import java.util.Optional;

@Repository
public interface NacionalidadeRepositorio extends JpaRepository<Nacionalidade,Long> {
    Optional<Nacionalidade> findByPais(String pais);
}
