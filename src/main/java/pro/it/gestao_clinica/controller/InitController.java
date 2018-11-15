package pro.it.gestao_clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.it.gestao_clinica.Command.UsuarioCommand;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;
import pro.it.gestao_clinica.service.ServiceUsuario;

import java.util.Optional;

@RestController
@RequestMapping("/clinica")
public class InitController {

    private ServiceUsuario serviceUsuario;

    public InitController( ServiceUsuario serviceUsuario ) {
        this.serviceUsuario = serviceUsuario;
    }

    @PostMapping("/login")
    public ResponseEntity< UsuarioCommand > index( @RequestBody UsuarioCommand usuario ){
        System.out.println( usuario );
        return  ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public String hello(){
        return "welcome";
    }

}
