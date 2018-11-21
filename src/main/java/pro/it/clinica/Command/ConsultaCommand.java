package pro.it.clinica.Command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ConsultaCommand {
    private Long id;
    private LocalDateTime dataActual;
    private LocalDateTime dataConsulta;
    private Boolean estado;
    private String Descricao;
    private MedicoCommand medico;
    private EspecialidadeCommand especialidadeSelecionada;
}
