package pro.it.clinica.model;

import lombok.*;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Fatura extends EntidadePadrao {

    @NotNull
    private LocalDateTime data;
    @NotNull
    @NotEmpty
    private String tipoFactura;
    @NotNull
    private Double valorTotal;

    @OneToOne
    private Consulta consulta;
    public Fatura(LocalDateTime data, String tipoFactura, Double valorTotal) {
        this.data = data;
        this.tipoFactura = tipoFactura;
        this.valorTotal = valorTotal;
    }
}
