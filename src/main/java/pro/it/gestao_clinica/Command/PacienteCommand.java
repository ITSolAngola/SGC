package pro.it.gestao_clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"consultas","contactos","nacionalidades"})
public class PacienteCommand {
    private Long id;
    private String nome;
    private String sobreNome;
    private LocalDate dataNAscimento;
    private String estadoCivil;
    private String genero;
    private Double peso;
    private EnderecoCommand endereco;
    private Set<ConsultaCommand> consultas = new HashSet<>();
    private Set<ContactoCommand> contactos = new HashSet<>();
    private Set<NacionalidadeCommand> nacionalidades = new HashSet<>();
}
