package pro.it.clinica.model;

import lombok.*;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Desconto extends EntidadePadrao {

    @NotNull
    private Integer limite;
    private String descricao;
    @NotNull
    private Double valor;


    public Desconto(Integer limite, String descricao, Double valor) {
        this.limite = limite;
        this.descricao = descricao;
        this.valor = valor;
    }

}
