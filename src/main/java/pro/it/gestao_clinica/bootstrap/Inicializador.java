package pro.it.gestao_clinica.bootstrap;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;
import pro.it.gestao_clinica.model.Usuario;
import pro.it.gestao_clinica.repository.UsuarioRepositorio;

@Slf4j
@Component
public class Inicializador implements ApplicationListener {



    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {


    }
}
