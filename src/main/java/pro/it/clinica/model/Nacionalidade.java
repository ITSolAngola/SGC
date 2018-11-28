package pro.it.clinica.model;


import lombok.*;
import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Nacionalidade extends EntidadePadrao {

    @NotNull
    @NotEmpty
    private String pais;

    @ManyToMany(mappedBy = "nacionalidades")
    private Set<Funcionario> funcionarios = new HashSet<>();

    @ManyToMany(mappedBy = "nacionalidades")
    private Set<Paciente> pacientes = new HashSet<>();
}
