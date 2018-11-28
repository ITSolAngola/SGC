package pro.it.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.Command.MedicoCommand;
import pro.it.clinica.Command.PacienteCommand;
import pro.it.clinica.service.ServiceConsulta;
import pro.it.clinica.service.ServiceMedico;
import pro.it.clinica.service.ServicePaciente;
import pro.it.clinica.repository.ConsultaRepositorio;

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
                                                    ConsultaCommand consultaCommand){

        ConsultaCommand novaConsulta = serviceConsulta.novo(consultaCommand);

        MedicoCommand medicoCommand = serviceMedico.pesquisarId(medicoId);
        PacienteCommand pacienteCommand = servicePaciente.pesquisarId(pacienteId);
        medicoCommand.getConsultas().add(novaConsulta);
        pacienteCommand.getConsultas().add(novaConsulta);

        servicePaciente.novo(pacienteCommand);
        serviceMedico.novo(medicoCommand);

        return  new ResponseEntity<>(novaConsulta, HttpStatus.OK);
    }


}
