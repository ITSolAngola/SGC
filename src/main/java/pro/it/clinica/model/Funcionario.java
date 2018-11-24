package pro.it.clinica.model;



import pro.it.clinica.model.padrao.Endereco;
import pro.it.clinica.model.padrao.Pessoa;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Funcionario extends Pessoa {

    private Boolean estado;
    @NotNull
    @NotEmpty
    private String cargo;

    @OneToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable( name ="nacionalidadesFunc", joinColumns  = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "nacionalidadeFuncionario_id"))
    private Set<Nacionalidade> nacionalidades = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "funcionario" )
    private Set<MedicoEspecialidade> medicoEspecialidades = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "funcionario_telefone")
    private Set<String> numTelefone = new HashSet<>();

    @ElementCollection
    private Set<String> email = new HashSet<>();



    public Funcionario() {
    }

    public Funcionario(Boolean estado , String cargo) {
        this.estado = estado;
        this.cargo = cargo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public Set<Nacionalidade> getNacionalidades() {
        return nacionalidades;
    }

    public void setNacionalidades(Set<Nacionalidade> nacionalidades) {
        this.nacionalidades = nacionalidades;
    }

    public Set<MedicoEspecialidade> getMedicoEspecialidades() {
        return medicoEspecialidades;
    }

    public void setMedicoEspecialidades(Set<MedicoEspecialidade> medicoEspecialidades) {
        this.medicoEspecialidades = medicoEspecialidades;
    }

}
