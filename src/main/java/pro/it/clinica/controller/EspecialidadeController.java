package pro.it.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.serviceImpl.EspecialidadeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/clinica/especialidade")
public class EspecialidadeController {

    private EspecialidadeServiceImpl especialidadeService;

    public EspecialidadeController(EspecialidadeServiceImpl especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @PostMapping("/add")
    public ResponseEntity<EspecialidadeCommand> adicionar(@RequestBody EspecialidadeCommand especialidadeCommand){
        return new ResponseEntity<>(especialidadeService.novo(especialidadeCommand),HttpStatus.CREATED);
    }

    @PostMapping("/listar")
    public ResponseEntity<List<EspecialidadeCommand>> listar(){
        return new ResponseEntity<>(especialidadeService.listar(),HttpStatus.CREATED);
    }


}
