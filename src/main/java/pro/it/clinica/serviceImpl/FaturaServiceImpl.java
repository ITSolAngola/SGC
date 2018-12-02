package pro.it.clinica.serviceImpl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.it.clinica.Command.FaturaCommand;
import pro.it.clinica.converterToCommand.FaturaCommandToFatura;
import pro.it.clinica.converterToModel.FaturaToFaturaCommand;

import pro.it.clinica.model.Fatura;
import pro.it.clinica.repository.FaturaRepositorio;
import pro.it.clinica.service.ServiceFatura;

@Service
public class FaturaServiceImpl implements ServiceFatura {

    private FaturaRepositorio faturaRepositorio;
    private FaturaCommandToFatura faturaCommandToFatura;
    private FaturaToFaturaCommand faturaToFaturaCommand;

    public FaturaServiceImpl(FaturaRepositorio faturaRepositorio,
                             FaturaCommandToFatura faturaCommandToFatura,
                             FaturaToFaturaCommand faturaToFaturaCommand) {
        this.faturaRepositorio = faturaRepositorio;
        this.faturaCommandToFatura = faturaCommandToFatura;
        this.faturaToFaturaCommand = faturaToFaturaCommand;
    }

    @Override
    public FaturaCommand gerar(FaturaCommand faturaCommand) {
        Fatura fatura = faturaCommandToFatura.convert(faturaCommand);
        return  faturaToFaturaCommand.convert( faturaRepositorio.save(fatura) );
    }

}
