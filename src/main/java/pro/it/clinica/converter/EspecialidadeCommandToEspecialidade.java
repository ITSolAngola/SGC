package pro.it.clinica.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import pro.it.clinica.Command.EspecialidadeCommand;
import pro.it.clinica.model.Especialidade;


@Service
public class EspecialidadeCommandToEspecialidade implements Converter<EspecialidadeCommand,Especialidade> {

    @Override
    public Especialidade convert(EspecialidadeCommand especialidadeCommand) {
        if( especialidadeCommand == null )
            return null;
        Especialidade especialidade = new Especialidade();
        especialidade.setId(especialidadeCommand.getId());
        especialidade.setNome(especialidadeCommand.getNome());
        especialidade.setPreco(especialidadeCommand.getPreco());
        return especialidade;
    }
}
