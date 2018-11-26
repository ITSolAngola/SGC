package pro.it.clinica.model;

import lombok.EqualsAndHashCode;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


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

    public Fatura() {
    }

    public Fatura(LocalDateTime data, String tipoFactura, Double valorTotal) {
        this.data = data;
        this.tipoFactura = tipoFactura;
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "data=" + data +
                ", tipoFactura='" + tipoFactura + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
