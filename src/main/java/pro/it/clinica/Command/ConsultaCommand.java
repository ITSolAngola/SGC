package pro.it.clinica.Command;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ConsultaCommand {
    private Long id;
    private LocalDateTime data;
    private LocalDateTime dataConsulta;
    private Boolean estado;
    private String Descricao;
    private String especialidade;
}
