package pro.it.gestao_clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DescontoCommand {
    private Long id;
    private Integer limite;
    private String descricao;
    private Double valor;
}
