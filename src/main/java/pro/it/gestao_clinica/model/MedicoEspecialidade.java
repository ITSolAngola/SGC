package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class MedicoEspecialidade extends EntidadePadrao {

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Especidade especidade;

    @OneToMany(mappedBy = "medicoEspecialidade")
    private Set<Consulta> consultas = new HashSet<>();

    public MedicoEspecialidade() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        funcionario.getMedicoEspecialidades().add(this);
        this.funcionario = funcionario;
    }

    public Especidade getEspecidade() {
        return especidade;
    }

    public void setEspecidade(Especidade especidade) {
        especidade.getMedicoEspecialidades().add(this);
        this.especidade = especidade;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void addConsultas( Consulta consulta ){
        consulta.setMedicoEspecialidade(this);
        getConsultas().add(consulta);
    }

}
