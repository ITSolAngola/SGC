package pro.it.gestao_clinica.model.padrao;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public class Pessoa extends EntidadePadrao {

    private String nome;
    private String sobreNome;
    private LocalDate dataNAscimento;
    private String estadoCivil;
    private String genero;

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public LocalDate getDataNAscimento() {
        return dataNAscimento;
    }

    public void setDataNAscimento(LocalDate dataNAscimento) {
        this.dataNAscimento = dataNAscimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
