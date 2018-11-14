package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.Endereco;
import pro.it.gestao_clinica.model.padrao.Pessoa;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "paciente")
public class Paciente extends Pessoa {

    private Double peso;

    @Embedded
    private Endereco endereco;

    public Paciente() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
