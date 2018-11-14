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

    @JoinTable( name ="nacionalidadesPaci", joinColumns  = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "naicionalidade_id"))
    private Set<Nacionalidade> nacionalidades = new HashSet<>();

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

    public Set<ContactoPaciente> getContactos() {
        return contactos;
    }

    public void setContactos(Set<ContactoPaciente> contactos) {
        this.contactos = contactos;
    }

    public void addContacto( ContactoPaciente contacto ){
        contacto.setPaciente(this);
        getContactos().add(contacto);
    }

    public Set<Nacionalidade> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(Set<Nacionalidade> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }
}
