package pro.it.gestao_clinica.Command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FacturaCommand {
    private Long id;
    private LocalDateTime data;
    private String tipoFactura;
    private Double valorTotal;
}
