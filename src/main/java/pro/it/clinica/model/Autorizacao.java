package pro.it.clinica.model;

import lombok.*;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Setter
@Getter
@ToString(exclude = {"usuario"})
@NoArgsConstructor
@Entity
public class Autorizacao extends EntidadePadrao {

    @NotNull
    private String descricao;

    @ManyToOne
    private Usuario usuario;

    public Autorizacao(@NotNull String descricao) {
        this.descricao = descricao;
    }
}
