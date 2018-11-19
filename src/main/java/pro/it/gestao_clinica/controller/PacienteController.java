package pro.it.gestao_clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.service.ServicePaciente;

import java.util.List;

@RestController
@RequestMapping("/clinica/paciente")
public class PacienteController {

    private ServicePaciente servicePaciente;

    public PacienteController(ServicePaciente servicePaciente) {
        this.servicePaciente = servicePaciente;
    }

    @GetMapping("/ver")
    public List<PacienteCommand> listar(){
        return servicePaciente.listar();
    }

    @PostMapping( "/add" )
    public ResponseEntity<PacienteCommand> novo(@RequestBody PacienteCommand pacienteCommand){
        PacienteCommand pacienteCommand1Novo = servicePaciente.adicionar(pacienteCommand);
        System.out.println("Command : "     + pacienteCommand);
        System.out.println("CommanNovo : "  + pacienteCommand1Novo);
        return new ResponseEntity<>( pacienteCommand1Novo,HttpStatus.CREATED );
    }


}
