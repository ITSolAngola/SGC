package pro.it.gestao_clinica.model.padrao;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Nacionalidade extends EntidadePadrao {

    private String pais;

    public Nacionalidade() {
    }

    public Nacionalidade(String descricao) {
        this.pais = descricao;
    }

    public String getDescricao() {
        return pais;
    }

    public void setDescricao(String descricao) {
        this.pais = descricao;
    }

}
