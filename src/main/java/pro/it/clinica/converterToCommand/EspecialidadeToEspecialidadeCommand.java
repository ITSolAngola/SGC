package pro.it.clinica.converterToCommand;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.model.Especialidade;

@Service
public class EspecialidadeToEspecialidadeCommand implements Converter<Especialidade,EspecialidadeCommand> {

    @Override
    public EspecialidadeCommand convert(Especialidade especialidade) {
        if(especialidade==null)
            return null;
        EspecialidadeCommand especialidadeCommand = new EspecialidadeCommand();
        especialidadeCommand.setId(especialidade.getId());
        especialidadeCommand.setNome(especialidade.getNome());
        especialidadeCommand.setPreco(especialidade.getPreco());
        return especialidadeCommand;
    }
}
