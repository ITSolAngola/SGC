package pro.it.clinica.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    private String nome;

    @NotNull
    private String senha;

    private Boolean estado;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario")
    private Set<Autorizacao> autorizacaos = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "usuario")
    private Funcionario funcionario;

    public Usuario(String password) {
        this.senha = password;
    }

    public Usuario() {
    }

    public Usuario(@NotNull @NotEmpty String senha, Boolean estado) {
        this.senha = senha;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Set<Autorizacao> getAutorizacaos() {
        return autorizacaos;
    }

    public void setAutorizacaos(Set<Autorizacao> autorizacaos) {
        this.autorizacaos = autorizacaos;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Usuario addPapeis(Autorizacao autorizacao){
        autorizacao.setUsuario(this);
        autorizacaos.add(autorizacao);
        return this;
    }

    public void setFuncionario(Funcionario funcionario) {
        funcionario.setUsuario(this);
        this.funcionario = funcionario;
    }
}