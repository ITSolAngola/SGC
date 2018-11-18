package pro.it.gestao_clinica.Command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsuarioCommand {
    private Long id;
    private String nome;
    private String senha;
    private Boolean estado;
    private Set<AutorizacaoCommand> autorizacoes = new HashSet<>();
}
