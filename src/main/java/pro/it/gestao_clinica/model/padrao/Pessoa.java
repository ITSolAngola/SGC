package pro.it.gestao_clinica.model.padrao;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
public class Pessoa extends EntidadePadrao {

    @NotEmpty
    @NotNull
    private String nome;
    @NotEmpty
    @NotNull
    private String sobreNome;
    @NotNull
    private LocalDate dataNAscimento;
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String estadoCivil;
    @Size(max = 30)
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

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", dataNAscimento=" + dataNAscimento +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

}
