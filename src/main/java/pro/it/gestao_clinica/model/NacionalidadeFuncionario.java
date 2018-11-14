package pro.it.gestao_clinica.model;


import pro.it.gestao_clinica.model.padrao.Nacionalidade;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
public class NacionalidadeFuncionario extends Nacionalidade {

    @ManyToMany(mappedBy = "nacionalidades")
    private Set<Funcionario> funcionarios = new HashSet<>();


}
