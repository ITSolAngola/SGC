package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Desconto extends EntidadePadrao {

    private Integer limite;
    private String descricao;
    private Double valor;

    @OneToMany( mappedBy = "desconto" )
    private Set<Consulta> consulta = new HashSet<>();

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

    public Set<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(Set<Consulta> consulta) {
        this.consulta = consulta;
    }

    public void addConsulta( Consulta consulta ){
        getConsulta().add(consulta);
    }
}
