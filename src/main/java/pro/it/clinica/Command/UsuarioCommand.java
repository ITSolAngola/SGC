package pro.it.clinica.Command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UsuarioCommand implements UserDetails{
    private Long id;
    private String nome;
    private String senha;
    private Boolean estado;
    private Set<AutorizacaoCommand> autorizacoes = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizacoes;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return estado;
    }

    @Override
    public boolean isAccountNonLocked() {
        return estado;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return estado;
    }

    @Override
    public boolean isEnabled() {
        return estado;
    }
}
