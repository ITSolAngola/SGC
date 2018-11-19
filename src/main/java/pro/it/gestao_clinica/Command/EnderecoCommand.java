package pro.it.gestao_clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnderecoCommand {
    private String pais;
    private String municipio;
    private String cidade;
    private String bairro;
    private String rua;
    private String numeroCasa;
}
