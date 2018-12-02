package pro.it.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.service.ServiceConsulta;
import pro.it.clinica.service.ServiceMedico;
import pro.it.clinica.service.ServicePaciente;
import pro.it.clinica.repository.ConsultaRepositorio;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/clinica/consulta")
public class ConsultaController {

    private ConsultaRepositorio consultaRepositorio;
    private ServiceMedico serviceMedico;
    private ServicePaciente servicePaciente;
    private ServiceConsulta serviceConsulta;

    public ConsultaController(ConsultaRepositorio consultaRepositorio,
                              ServiceMedico serviceMedico,
                              ServicePaciente servicePaciente,
                              ServiceConsulta serviceConsulta) {
        this.consultaRepositorio = consultaRepositorio;
        this.serviceMedico = serviceMedico;
        this.servicePaciente = servicePaciente;
        this.serviceConsulta = serviceConsulta;
    }

    @PostMapping("/medico/{medicoId}/paciente/{pacienteId}")
    public ResponseEntity<ConsultaCommand> cadastro(@PathVariable Long medicoId,
                                                    @PathVariable Long pacienteId,
                                                    @RequestBody ConsultaCommand consultaCommand){

        consultaCommand.setDataHoje(LocalDateTime.now());
        Consulta consulta = serviceConsulta.get(consultaCommand);

        MedicoCommand medicoCommand = serviceMedico.pesquisarId(medicoId);
        PacienteCommand pacienteCommand = servicePaciente.pesquisarId(pacienteId);

        consulta.setFuncionario(serviceMedico.get(medicoCommand));
        consulta.setPaciente(servicePaciente.get(pacienteCommand));
        ConsultaCommand consultaCommand1 = serviceConsulta.cadastrar(consulta);

        return  new ResponseEntity<>(consultaCommand1, HttpStatus.OK);

    }


}
