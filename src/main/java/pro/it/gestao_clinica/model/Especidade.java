package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Especidade extends EntidadePadrao {

    private String nome;
    private Double preco;

    public Especidade() {
    }

    public Especidade(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Especidade{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
