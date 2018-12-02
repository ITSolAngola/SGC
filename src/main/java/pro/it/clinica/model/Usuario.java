package pro.it.clinica.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString(exclude = {"funcionario","autorizacaos"})
@NoArgsConstructor
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

    public Usuario(@NotNull @NotEmpty String senha, Boolean estado) {
        this.senha = senha;
        this.estado = estado;
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