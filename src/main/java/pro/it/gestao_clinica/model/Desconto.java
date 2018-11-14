package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;

@Entity
public class Desconto extends EntidadePadrao {

    private Integer limite;
    private String descricao;
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
