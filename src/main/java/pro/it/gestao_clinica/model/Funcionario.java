package pro.it.gestao_clinica.model;



import pro.it.gestao_clinica.model.padrao.Endereco;
import pro.it.gestao_clinica.model.padrao.Pessoa;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Funcionario extends Pessoa {

    private Boolean estado;
    @NotNull
    @NotEmpty
    private String cargo;

    @OneToOne
    private Usuario usuario;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "funcionario")
    private Set<ContactoFuncionario> contatos = new HashSet<>();

    @ManyToMany
    @JoinTable( name ="nacionalidadesFunc", joinColumns  = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "nacionalidadeFuncionario_id"))
    private Set<Nacionalidade> nacionalidades = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "funcionario" )
    private Set<MedicoEspecialidade> medicoEspecialidades = new HashSet<>();

    @Embedded
    private Endereco endereco;

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

    public Set<ContactoFuncionario> getContatos() {
        return contatos;
    }

    public void setContatos(Set<ContactoFuncionario> contatos) {
        this.contatos = contatos;
    }

    public void addContacto( ContactoFuncionario contacto ){
        contacto.setFuncionario(this);
        getContatos().add(contacto);
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

    public void addEspecialidade( MedicoEspecialidade medicoEspecialidade ){
        medicoEspecialidade.setFuncionario(this);
        getMedicoEspecialidades().add(medicoEspecialidade);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
