package pro.it.gestao_clinica.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AutorizacaoCommand  implements GrantedAuthority  {
    private Long id;
    private String descricao;

    @Override
    public String getAuthority() {
        return descricao;
    }
}
