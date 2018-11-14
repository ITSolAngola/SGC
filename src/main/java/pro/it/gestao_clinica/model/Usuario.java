package pro.it.gestao_clinica.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;
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
}