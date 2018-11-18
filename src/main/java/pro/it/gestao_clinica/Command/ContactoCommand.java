package pro.it.gestao_clinica.Command;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ContactoCommand {
    private Long id;
    private String numeroTelefone;
    private String email;
}
