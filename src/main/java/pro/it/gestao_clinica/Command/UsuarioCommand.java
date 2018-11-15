package pro.it.gestao_clinica.Command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsuarioCommand {
    private String nome;
    private String senha;
    private Boolean estado;
}
