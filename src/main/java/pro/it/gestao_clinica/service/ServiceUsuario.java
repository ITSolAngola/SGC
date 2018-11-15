package pro.it.gestao_clinica.service;

import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;

public interface ServiceUsuario {
    UsuarioCommand confirmacao(UsuarioCommand usuario);
}
