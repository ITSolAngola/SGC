package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Nacionalidade extends EntidadePadrao {

    @ManyToMany(mappedBy = "nacionalidades")
    private Set<Funcionario> funcionarios = new HashSet<>();


}
