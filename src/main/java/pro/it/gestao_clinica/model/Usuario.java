package pro.it.gestao_clinica.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;

    @NotNull
    private String senha;

    private Boolean estado;

    @ManyToMany
    @JoinTable(name="autorizacao",
            joinColumns = @JoinColumn(name="usuario_nome"),
            inverseJoinColumns = @JoinColumn(name="papel_id"))
    private Set<Papel> papeis = new HashSet<>();

    @OneToOne
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

    public Set<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(Set<Papel> papeis) {
        this.papeis = papeis;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        funcionario.setUsuario(this);
        this.funcionario = funcionario;
    }
}
