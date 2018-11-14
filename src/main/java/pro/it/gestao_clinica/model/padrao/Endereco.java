package pro.it.gestao_clinica.model.padrao;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco {

     @NotNull
     @NotEmpty
     private String pais;
     @NotNull
     @NotEmpty
     private String muinicipio;
     @NotNull
     @NotEmpty
     private String cidade;
     @NotNull
     @NotEmpty
     private String bairro;
     @NotNull
     @NotEmpty
     private String rua;
     @NotNull
     @NotEmpty
     private String nCasa;

    public Endereco() {
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMuinicipio() {
        return muinicipio;
    }

    public void setMuinicipio(String muinicipio) {
        this.muinicipio = muinicipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getnCasa() {
        return nCasa;
    }

    public void setnCasa(String nCasa) {
        this.nCasa = nCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
