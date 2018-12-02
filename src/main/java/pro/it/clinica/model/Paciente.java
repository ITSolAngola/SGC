package pro.it.clinica.model;

import lombok.*;
import pro.it.clinica.model.padrao.Endereco;
import pro.it.clinica.model.padrao.Pessoa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
@ToString(exclude = {"consultas","nacionalidades"})
@NoArgsConstructor
@Entity
public class Paciente extends Pessoa {

    @NotNull
    private Double peso;

    @OneToMany( mappedBy = "paciente")
    private Set<Consulta> consultas = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "paciente_telefone")
    private Set<String> numTelefone= new HashSet<>();

    @ElementCollection
    private Set<String> email= new HashSet<>();

    @ManyToMany
    @JoinTable( name ="nacionalidadesPaci", joinColumns  = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "naicionalidade_id"))
    private Set<Nacionalidade> nacionalidades = new HashSet<>();

    public void addConsulta(Consulta consulta){
        consultas.add(consulta);
    }

    public  Set<Nacionalidade> addNacionalidade(Nacionalidade nacionalidade){
        nacionalidade.getPacientes().add(this);
        nacionalidades.add(nacionalidade);
        return nacionalidades;
    }
}
