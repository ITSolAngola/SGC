package pro.it.clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class FuncionarioCommand extends PessoaCommand {
    private String cargo;
}
