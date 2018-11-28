package pro.it.clinica.model;



import lombok.*;
import pro.it.clinica.model.padrao.Endereco;
import pro.it.clinica.model.padrao.Pessoa;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Funcionario extends Pessoa {

    private Boolean estado;
    @NotNull
    @NotEmpty
    private String cargo;

    @OneToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable( name ="nacionalidadesFunc", joinColumns  = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "nacionalidadeFuncionario_id"))
    private Set<Nacionalidade> nacionalidades = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "funcionario_telefone")
    private Set<String> numTelefone = new HashSet<>();

    @ManyToMany
            @JoinTable(name = "medico_especialidade",joinColumns = @JoinColumn(name="funcionario_id"),
            inverseJoinColumns = @JoinColumn(name="especialidade_id"))
    Set<Especialidade> especialidades = new HashSet<>();

    @OneToMany(mappedBy = "funcionario")
    Set<Consulta> consultas = new HashSet<>();

    @ElementCollection
    private Set<String> email = new HashSet<>();

    public void addConsulta(Consulta consulta){
        consulta.setFuncionario(this);
        consultas.add(consulta);
    }


}
