package pro.it.clinica.service;

import pro.it.clinica.Command.PacienteCommand;

import java.util.List;

public interface ServicePaciente {


    PacienteCommand adicionar( PacienteCommand paciente );
    List<PacienteCommand> listar();
    PacienteCommand pesquisarId(Long id);
}
