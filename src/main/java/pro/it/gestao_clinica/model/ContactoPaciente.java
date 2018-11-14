package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.Contacto;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "contactoPaciente")
public class ContactoPaciente extends Contacto {

    @ManyToOne
    private Paciente paciente;
}
