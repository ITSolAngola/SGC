package pro.it.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.it.clinica.Command.MedicoCommand;

import pro.it.clinica.service.ServiceEspecialidade;
import pro.it.clinica.service.ServiceMedico;
import pro.it.clinica.service.ServiceNacionalidade;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clinica/medico")
public class MedicoController {

    private ServiceMedico serviceMedico;
    private ServiceNacionalidade nacionalidadeService;
    private ServiceEspecialidade serviceEspecialidade;

    public MedicoController(ServiceMedico serviceMedico, ServiceNacionalidade nacionalidadeService, ServiceEspecialidade serviceEspecialidade) {
        this.serviceMedico = serviceMedico;
        this.nacionalidadeService = nacionalidadeService;
        this.serviceEspecialidade = serviceEspecialidade;
    }

    @PostMapping
    public ResponseEntity<MedicoCommand> adicionar(@RequestBody MedicoCommand medicoCommand){

        medicoCommand.setEspecialidades(serviceEspecialidade.validaList(medicoCommand
                                        .getEspecialidades()));

        medicoCommand.setNacionalidades(nacionalidadeService.validaSet(medicoCommand
                                                                        .getNacionalidades()));

        return new ResponseEntity<>( serviceMedico.novo(medicoCommand) , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicoCommand>> listar(){
        return new ResponseEntity<>( serviceMedico.listar() , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<MedicoCommand> ver(@PathVariable Long id){

        MedicoCommand medicoCommand = serviceMedico.pesquisarId(id);
        System.out.println("Viu : " + medicoCommand);
        if(medicoCommand==null)
            ResponseEntity.notFound().build();

        return new ResponseEntity<>( medicoCommand , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editar(@PathVariable Long id,
                            @RequestBody MedicoCommand medicoCommand){
        MedicoCommand medicoCommand1 = serviceMedico.pesquisarId(id);

        if( medicoCommand1 == null ){
            ResponseEntity.notFound().build();
        }

         medicoCommand.setEspecialidades(serviceEspecialidade.validaList(medicoCommand
                .getEspecialidades()));

         medicoCommand.setNacionalidades(nacionalidadeService.validaSet(medicoCommand
                .getNacionalidades()));

         medicoCommand.setId(medicoCommand1.getId());

        serviceMedico.novo(medicoCommand);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
