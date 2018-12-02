package pro.it.clinica.service;

import java.util.List;

public interface ServiceGenerico<T,V> {
    T novo(T t);
    List<T> listar();
    T pesquisarId(Long id);
    V get(T t);
}
