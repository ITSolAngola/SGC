package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.Contacto;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "contactoPaciente")
public class ContactoPaciente extends Contacto {

    @NotNull
    @ManyToOne
    private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
