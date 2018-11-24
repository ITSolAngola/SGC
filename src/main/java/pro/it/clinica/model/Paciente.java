package pro.it.clinica.model;

import pro.it.clinica.model.padrao.Endereco;
import pro.it.clinica.model.padrao.Pessoa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Paciente extends Pessoa {

    @NotNull
    private Double peso;

    @OneToMany( mappedBy = "paciente")
    private Set<Consulta> consultas = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "paciente_telefone")
    private Set<String> numTelefone= new HashSet<>();

    @ElementCollection
    private Set<String> email= new HashSet<>();

    @ManyToMany
    @JoinTable( name ="nacionalidadesPaci", joinColumns  = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "naicionalidade_id"))
    private Set<Nacionalidade> nacionalidades = new HashSet<>();


    public Paciente() {
    }

    public Set<String> getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(Set<String> numTelefone) {
        this.numTelefone = numTelefone;
    }

    public Set<String> getEmail() {
        return email;
    }

    public void setEmail(Set<String> email) {
        this.email = email;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void addConsulta(Consulta consulta){
        consulta.setPaciente(this);
        getConsultas().add(consulta);
    }

    public Set<Nacionalidade> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(Set<Nacionalidade> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }

    public  Set<Nacionalidade> addNacionalidade(Nacionalidade nacionalidade){
        nacionalidade.getPacientes().add(this);
        getNacionalidades().add(nacionalidade);
        return nacionalidades;
    }
}
