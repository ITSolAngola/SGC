package pro.it.clinica.model;


import lombok.*;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;



@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Especialidade extends EntidadePadrao {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private Double preco;

    @ManyToMany(mappedBy = "especialidades")
    Set<Funcionario> funcionarios = new HashSet<>();

    @OneToMany
    Set<Consulta> consultas = new HashSet<>();

    public Especialidade(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void addConsulta(Consulta consulta){
        consulta.setEspecialidade(this);
        consultas.add(consulta);
    }

}
