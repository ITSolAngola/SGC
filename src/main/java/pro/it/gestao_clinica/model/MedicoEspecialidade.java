package pro.it.gestao_clinica.model;

import pro.it.gestao_clinica.model.padrao.EntidadePadrao;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class MedicoEspecialidade extends EntidadePadrao {

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Especidade especidade;

    @OneToMany(mappedBy = "medicoEspecialidade")
    private Set<Consulta> consultas = new HashSet<>();


}
