package pro.it.clinica.model.padrao;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@MappedSuperclass
public class Pessoa extends EntidadePadrao {

    @NotEmpty
    @NotNull
    protected String nome;
    @NotEmpty
    @NotNull
    protected String sobreNome;
    protected LocalDate dataNascimento;
    @NotEmpty
    @Size(max = 30)
    protected String estadoCivil;
    @Size(max = 30)
    protected String genero;

    @Embedded
    protected Endereco endereco;

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", genero='" + genero + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
