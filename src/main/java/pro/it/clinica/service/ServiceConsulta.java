package pro.it.clinica.service;

import pro.it.clinica.Command.ConsultaCommand;
import pro.it.clinica.model.Consulta;
import pro.it.clinica.model.Funcionario;
import pro.it.clinica.model.Paciente;

public interface ServiceConsulta extends  ServiceGenerico<ConsultaCommand,Consulta> {
    ConsultaCommand cadastrar(Consulta consulta);
}
