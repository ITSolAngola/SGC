package pro.it.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.it.clinica.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String>{
    Optional<Usuario> findByNome(String nome);
}
