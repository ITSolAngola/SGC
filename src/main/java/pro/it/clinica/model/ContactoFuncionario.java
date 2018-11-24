package pro.it.clinica.model;

import pro.it.clinica.model.padrao.Contacto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table( name = "contactoMedico")
public class ContactoFuncionario extends Contacto {

    @NotNull
    @ManyToOne
    private Funcionario funcionario;

    public ContactoFuncionario() {
    }

  /*  public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        funcionario.getContatos().add(this);
        this.funcionario = funcionario;
    }*/


}
