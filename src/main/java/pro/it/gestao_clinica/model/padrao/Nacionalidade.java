package pro.it.gestao_clinica.model.padrao;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Nacionalidade extends EntidadePadrao {

    private String descricao;

    public Nacionalidade() {
    }

    public Nacionalidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
