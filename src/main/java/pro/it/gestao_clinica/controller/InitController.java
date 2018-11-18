package pro.it.gestao_clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;
import pro.it.gestao_clinica.service.ServicePaciente;
import pro.it.gestao_clinica.service.ServiceUsuario;
import pro.it.gestao_clinica.serviceImpl.PacienteServiceImpl;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/clinica")
public class InitController {

    private ServiceUsuario serviceUsuario;

    public InitController( ServiceUsuario serviceUsuario ) {
        this.serviceUsuario = serviceUsuario;
    }

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Estou aqui");
    }

}
