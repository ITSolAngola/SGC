package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.Contacto;
import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table( name = "contactoMedico")
public class ContactoMedico extends Contacto {
}
