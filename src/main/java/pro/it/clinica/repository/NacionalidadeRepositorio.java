package pro.it.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.it.clinica.model.Nacionalidade;

@Repository
public interface NacionalidadeRepositorio extends JpaRepository<Nacionalidade,Long> {
    Nacionalidade findByPais(String pais);
}
