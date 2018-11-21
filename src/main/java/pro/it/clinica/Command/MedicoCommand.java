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
public class MedicoCommand {
    private Long id;
    private String nome;
    private String sobreNome;
    private LocalDate dataNAscimento;
    private String estadoCivil;
    private String genero;
    private Boolean estado;
    private String cargo;
    private UsuarioCommand usuario;
    private Set<ContactoCommand> contatos = new HashSet<>();
    private Set<NacionalidadeCommand> nacionalidades = new HashSet<>();
    private EnderecoCommand endereco;

}
