package pro.it.clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class NacionalidadeCommand {
    private Long id;
    private String pais;
}
