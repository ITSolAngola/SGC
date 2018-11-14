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

}
