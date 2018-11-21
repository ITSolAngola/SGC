package pro.it.clinica.model.padrao;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Contacto extends EntidadePadrao {

    @NotEmpty
    private String numeroTelefone;
    @Size(max = 255)
    private String email;

    public Contacto() {
    }

    public Contacto(String nPhone, String email) {
        this.numeroTelefone = nPhone;
        this.email = email;
    }

    public String getnPhone() {
        return numeroTelefone;
    }

    public void setnPhone(String nPhone) {
        this.numeroTelefone = nPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "numeroTelefone='" + numeroTelefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
