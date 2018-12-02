package pro.it.clinica.model;

import lombok.*;
import pro.it.clinica.bootstrap.EstadoConsulta;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = {"paciente","fatura","funcionario"})
@NoArgsConstructor
@Entity
public class Consulta extends EntidadePadrao {

    @NotNull
    private LocalDateTime dataActual;
    @NotNull
    private LocalDateTime dataConsulta;

    @Enumerated(EnumType.STRING)
    private EstadoConsulta estado;
    private String Descricao;

    @ManyToOne
    private Paciente paciente;

    @ManyToMany(mappedBy = "consulta")
    private Set<Fatura> faturas = new HashSet<>();

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Especialidade Especialidade;


    public void addFuncinario(Funcionario funcionario){
        funcionario.addConsulta(this);
        this.funcionario = funcionario;

    }

    public void addPaciente( Paciente paciente ){
        paciente.addConsulta(this);
        this.paciente = paciente;
    }

}
