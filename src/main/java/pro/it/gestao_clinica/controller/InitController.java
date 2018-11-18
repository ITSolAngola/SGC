package pro.it.gestao_clinica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/clinica")
public class InitController {

    @GetMapping
    public ResponseEntity<Principal> hello(Principal principal){
        return ResponseEntity.ok(principal);
    }

}
