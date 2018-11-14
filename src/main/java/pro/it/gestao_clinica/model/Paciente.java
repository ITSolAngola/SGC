package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.Endereco;
import pro.it.gestao_clinica.model.padrao.Pessoa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "paciente")
public class Paciente extends Pessoa {

    private Double peso;

    @OneToMany( mappedBy = "paciente")
    private Set<Consulta> consultas = new HashSet<>();

    @OneToMany( mappedBy = "paciente" )
    private Set<ContactoPaciente> contactos = new HashSet<>();

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
