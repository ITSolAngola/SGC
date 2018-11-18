package pro.it.gestao_clinica.service;

import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;

public interface ServiceUsuario {
    Boolean confirmacao(UsuarioCommand usuario);
}
