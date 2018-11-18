package pro.it.gestao_clinica.seguranca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import pro.it.gestao_clinica.config.DetalhesUsuarioImpl;

import javax.sql.DataSource;

@EnableWebSecurity
public class SegurancaRest extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DetalhesUsuarioImpl detalhesUsuario;

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
                .antMatchers("/console/**").permitAll()
                .antMatchers("/clinica").authenticated()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}
