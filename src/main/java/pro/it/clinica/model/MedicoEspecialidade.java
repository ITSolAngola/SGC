package pro.it.clinica.model;

import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MedicoEspecialidade extends EntidadePadrao {

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Especialidade especialidade;

    @OneToMany(mappedBy = "medicoEspecialidade")
    private Set<Consulta> consultas = new HashSet<>();

    public MedicoEspecialidade() {
    }

    public MedicoEspecialidade(Funcionario funcionario, Especialidade especialidade) {
        funcionario.getMedicoEspecialidades().add(this);
        this.funcionario = funcionario;
        especialidade.getMedicoEspecialidades().add(this);
        this.especialidade = especialidade;
    }

    public MedicoEspecialidade(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
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
