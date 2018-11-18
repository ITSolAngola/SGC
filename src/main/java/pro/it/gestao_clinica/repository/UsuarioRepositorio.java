package pro.it.gestao_clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,String>{
    Optional<Usuario> findByNome(String nome);
}
