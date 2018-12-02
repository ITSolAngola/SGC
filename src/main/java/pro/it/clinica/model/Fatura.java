package pro.it.clinica.model;

import lombok.*;
import pro.it.clinica.bootstrap.TipoFatura;
import pro.it.clinica.bootstrap.TipoPagamento;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = {"consulta"})
@NoArgsConstructor
@Entity
public class Fatura extends EntidadePadrao {
    @NotNull
    private Long nFatura;
    @NotNull
    private LocalDateTime data;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoFatura tipoFactura;
    @NotNull
    private Double valorTotal;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @ManyToMany
    @JoinTable(name = "itemConsulta",joinColumns = @JoinColumn(name="fatura_id"),
    inverseJoinColumns = @JoinColumn(name = "consulta_id"))
    private Set<Consulta> consultas = new HashSet<>();

    public void addConsulta(Consulta consulta){
        consulta.getFaturas().add(this);
        consultas.add(consulta);
    }

}
