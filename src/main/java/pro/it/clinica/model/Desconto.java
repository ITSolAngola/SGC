package pro.it.clinica.model;

import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Desconto extends EntidadePadrao {

    @NotNull
    private Integer limite;
    private String descricao;
    @NotNull
    private Double valor;


    public Desconto(Integer limite, String descricao, Double valor) {
        this.limite = limite;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Desconto() {
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
