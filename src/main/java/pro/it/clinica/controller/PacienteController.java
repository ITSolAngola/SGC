package pro.it.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.service.ServicePaciente;

import java.util.List;

@RestController
@RequestMapping("/clinica/paciente")
public class PacienteController {

    private ServicePaciente servicePaciente;

    public PacienteController(ServicePaciente servicePaciente) {
        this.servicePaciente = servicePaciente;
    }

    @GetMapping
    public List<PacienteCommand> listar(){
        return servicePaciente.listar();
    }

    @PostMapping
    public ResponseEntity<PacienteCommand> novo(@RequestBody PacienteCommand pacienteCommand) {
        PacienteCommand pacienteCommand1Novo = servicePaciente.novo(pacienteCommand);
        System.out.println("Command : "     + pacienteCommand);
        System.out.println("CommanNovo : "  + pacienteCommand1Novo);
        return new ResponseEntity<>( pacienteCommand1Novo,HttpStatus.CREATED );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteCommand> ver( @PathVariable Long id){
        PacienteCommand pacienteCommand = servicePaciente.pesquisarId(id);
        if( pacienteCommand == null )
          return  ResponseEntity.notFound().build();
        System.out.println("ID = " + id);
        System.out.println("PACINTE " + pacienteCommand);
        return new ResponseEntity<>(pacienteCommand,HttpStatus.ACCEPTED);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<PacienteCommand> alterar(@PathVariable Long id,@RequestBody PacienteCommand pacienteCommand){

        PacienteCommand pacienteCommand1 = servicePaciente.pesquisarId(id);
        if( pacienteCommand1 == null ){
            return ResponseEntity.notFound().build();
        }

        if( !pacienteCommand1.getId().equals(id))
            return ResponseEntity.notFound().build();

        pacienteCommand = servicePaciente.novo(pacienteCommand);
        return new ResponseEntity<>(pacienteCommand,HttpStatus.ACCEPTED);
    }


}
