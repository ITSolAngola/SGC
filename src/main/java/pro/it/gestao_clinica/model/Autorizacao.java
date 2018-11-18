package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Autorizacao extends EntidadePadrao{

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
