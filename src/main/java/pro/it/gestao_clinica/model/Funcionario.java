package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.Endereco;
import pro.it.gestao_clinica.model.padrao.Pessoa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Funcionario extends Pessoa {

    private Boolean estado;
    private String cargo;

    @OneToOne( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Usuario usuario;

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "funcionario")
    private Set<ContactoFuncionario> contatos = new HashSet<>();

    @ManyToMany
    @JoinTable( name ="nacionalidadesFunc", joinColumns  = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "nacionalidadeFuncionario_id"))
    private Set<NacionalidadeFuncionario> nacionalidades = new HashSet<>();

    @OneToMany( cascade = CascadeType.ALL , mappedBy = "funcionario" )
    private Set<MedicoEspecialidade> medicoEspecialidades = new HashSet<>();


    @Embedded
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}
