package pro.it.clinica.Command;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class EspecialidadeCommand {
    private Long id;
    private String nome;
    private Double preco;
}
