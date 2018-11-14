package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.Contacto;
import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table( name = "contactoMedico")
public class ContactoFuncionario extends Contacto {

    @ManyToOne
    private Funcionario funcionario;

    public ContactoFuncionario() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        funcionario.getContatos().add(this);
        this.funcionario = funcionario;
    }


}
