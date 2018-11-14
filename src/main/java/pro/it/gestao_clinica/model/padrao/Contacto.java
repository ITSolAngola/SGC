package pro.it.gestao_clinica.model.padrao;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Contacto extends EntidadePadrao {

    private String nPhone;
    private String email;

    public Contacto() {
    }

    public Contacto(String nPhone, String email) {
        this.nPhone = nPhone;
        this.email = email;
    }

    public String getnPhone() {
        return nPhone;
    }

    public void setnPhone(String nPhone) {
        this.nPhone = nPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
