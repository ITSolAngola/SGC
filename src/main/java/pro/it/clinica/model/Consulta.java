package pro.it.clinica.model;

import lombok.*;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Consulta extends EntidadePadrao {

    @NotNull
    private LocalDateTime dataActual;
    @NotNull
    private LocalDateTime dataConsulta;
    @NotNull
    private Boolean estado;
    @Null
    private String Descricao;

    @ManyToOne
    private Paciente paciente;

    @OneToOne
    private Fatura fatura;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Especialidade Especialidade;

    public Consulta(LocalDateTime dataMarcada, LocalDateTime dataConsulta, String descricao) {
        this.dataActual = dataMarcada;
        this.dataConsulta = dataConsulta;
        this.estado = true;
        Descricao = descricao;
    }

}
