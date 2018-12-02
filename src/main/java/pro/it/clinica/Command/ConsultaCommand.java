package pro.it.clinica.Command;


import lombok.*;
import pro.it.clinica.bootstrap.EstadoConsulta;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ConsultaCommand {
    private Long id;
    private LocalDateTime dataHoje;
    private LocalDateTime dataConsulta;
    private EstadoConsulta estado;
    private String Descricao;
    private EspecialidadeCommand especialidadeCommand;
}
