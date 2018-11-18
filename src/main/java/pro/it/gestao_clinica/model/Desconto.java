package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

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
