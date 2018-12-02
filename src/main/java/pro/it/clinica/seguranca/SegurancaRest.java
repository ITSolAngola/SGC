package pro.it.clinica.seguranca;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import pro.it.clinica.configuracao.DetalhesUsuarioImpl;


@EnableWebSecurity
public class SegurancaRest extends WebSecurityConfigurerAdapter {


    private DetalhesUsuarioImpl detalhesUsuario;

    public SegurancaRest(DetalhesUsuarioImpl detalhesUsuario) {
        this.detalhesUsuario = detalhesUsuario;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detalhesUsuario)
        .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/console/**","/console").hasRole("ADMIN")
                .antMatchers("/clinica/**").hasAnyRole("ADMIN","MEDICO")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
