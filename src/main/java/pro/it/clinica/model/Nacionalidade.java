package pro.it.clinica.model;


import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Nacionalidade extends EntidadePadrao {

    @NotNull
    @NotEmpty
    private String pais;

    @ManyToMany(mappedBy = "nacionalidades")
    private Set<Funcionario> funcionarios = new HashSet<>();

    @ManyToMany(mappedBy = "nacionalidades")
    private Set<Paciente> pacientes = new HashSet<>();

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Nacionalidade{" +
                "pais='" + pais + '\'' +
                '}';
    }
}
