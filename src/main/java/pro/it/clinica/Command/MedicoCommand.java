package pro.it.clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pro.it.clinica.model.Consulta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MedicoCommand extends FuncionarioCommand {

    private Set<EspecialidadeCommand> especialidadeCommands = new HashSet<>();
}
