package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Papel extends EntidadePadrao {

    private String descricao;

    @ManyToMany( mappedBy = "papeis")
    private Set<Usuario> usuario = new HashSet<>();

    public Papel() {
    }

    public Papel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Papel{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
