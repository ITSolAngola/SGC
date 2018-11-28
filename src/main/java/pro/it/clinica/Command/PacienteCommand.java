package pro.it.clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"consultas","contactos","nacionalidades"})
public class PacienteCommand extends PessoaCommand {
    private Double peso;
    Set<ConsultaCommand> consultas = new HashSet<>();
}
