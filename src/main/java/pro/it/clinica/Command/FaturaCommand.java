package pro.it.clinica.Command;


import lombok.*;
import pro.it.clinica.bootstrap.TipoFatura;
import pro.it.clinica.bootstrap.TipoPagamento;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FaturaCommand {
    private Long id;
    private Long nFatura;
    private LocalDateTime data;
    private TipoFatura tipoFactura;
    private TipoPagamento tipoPagamento;
    private Double valorTotal;
    private Set<ConsultaCommand> consultas = new HashSet<>();
}
