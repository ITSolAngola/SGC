package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Fatura extends EntidadePadrao {

    private LocalDateTime data;
    private String tipoFactura;
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

}
