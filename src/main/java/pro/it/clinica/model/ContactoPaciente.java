package pro.it.clinica.model;

import pro.it.clinica.model.padrao.Contacto;

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

    public ContactoPaciente() {
    }

    public ContactoPaciente(String nPhone, String email) {
        super(nPhone, email);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
