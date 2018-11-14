package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.Nacionalidade;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "nacionalidadeMedico" )
public class NacionalidadeMedico extends Nacionalidade {
}
