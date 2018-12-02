package pro.it.clinica.service;

import pro.it.clinica.Command.FaturaCommand;
import pro.it.clinica.model.Consulta;

import java.util.Set;

public interface ServiceFatura {
    FaturaCommand gerar(FaturaCommand faturaCommand);
}
