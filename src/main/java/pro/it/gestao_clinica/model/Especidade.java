package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Especidade extends EntidadePadrao {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private Double preco;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "especidade" )
    private Set<MedicoEspecialidade> medicoEspecialidades = new HashSet<>();


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


    public Set<MedicoEspecialidade> getMedicoEspecialidades() {
        return medicoEspecialidades;
    }

    public void setMedicoEspecialidades(Set<MedicoEspecialidade> medicoEspecialidades) {
        this.medicoEspecialidades = medicoEspecialidades;
    }

    @Override
    public String toString() {
        return "Especidade{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
