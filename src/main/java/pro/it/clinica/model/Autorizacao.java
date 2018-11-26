package pro.it.clinica.model;

import lombok.EqualsAndHashCode;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Autorizacao extends EntidadePadrao {

    @NotNull
    private String descricao;

    @ManyToOne
    private Usuario usuario;

    public Autorizacao() {
    }

    public Autorizacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Autorizacao{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
