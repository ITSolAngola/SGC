package pro.it.clinica.Command;

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
@ToString
public abstract  class PessoaCommand {
    private Long id;
    private String nome;
    private String sobreNome;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String genero;
    private EnderecoCommand endereco;
    private Set<String> numeroTelefone = new HashSet<>();
    private Set<String> email = new HashSet<>();
    private Set<NacionalidadeCommand> nacionalidades = new HashSet<>();
}
