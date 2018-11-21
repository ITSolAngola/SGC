package pro.it.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.service.ServiceEspecialidade;
import pro.it.clinica.serviceImpl.EspecialidadeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/clinica/especialidade")
public class EspecialidadeController {

    private ServiceEspecialidade especialidadeService;

    public EspecialidadeController(ServiceEspecialidade especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    @PostMapping("/add")
    public ResponseEntity<EspecialidadeCommand> adicionar(@RequestBody EspecialidadeCommand especialidadeCommand){
        return new ResponseEntity<>(especialidadeService.novo(especialidadeCommand),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EspecialidadeCommand>> listar(){
        List<EspecialidadeCommand> listeEspecialidade = especialidadeService.listar();
        return new ResponseEntity<>(listeEspecialidade,HttpStatus.OK);
    }


}
