package pro.it.clinica.model;


import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Especialidade extends EntidadePadrao {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private Double preco;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "especialidade" )
    private Set<MedicoEspecialidade> medicoEspecialidades = new HashSet<>();

    public Especialidade() {
    }

    public Especialidade(String nome, Double preco) {
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
        return "ServiceEspecialidade{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
