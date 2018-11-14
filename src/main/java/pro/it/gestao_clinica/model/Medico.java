package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.Endereco;
import pro.it.gestao_clinica.model.padrao.Pessoa;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Medico extends Pessoa {

    private Boolean estado;
    @Embedded
    private Endereco endereco;

    public Medico() {
    }

    public Medico(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}
