package pro.it.gestao_clinica.service;

import pro.it.gestao_clinica.Command.PacienteCommand;
import pro.it.gestao_clinica.model.Paciente;

import java.util.List;

public interface ServicePaciente {


    PacienteCommand adicionar( PacienteCommand paciente );
    PacienteCommand editar( PacienteCommand paciente );
    List<PacienteCommand> listar();


}
