package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.Endereco;
import pro.it.gestao_clinica.model.padrao.Pessoa;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

    private Boolean estado;
    private String cargo;

    @Embedded
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}
