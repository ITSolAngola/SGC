package pro.it.gestao_clinica.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Consulta {

    private LocalDateTime dataMarcada;
    private LocalDateTime dataConsulta;
    private Boolean estado;
    private String Descricao;

    public Consulta(LocalDateTime dataMarcada, LocalDateTime dataConsulta, Boolean estado, String descricao) {
        this.dataMarcada = dataMarcada;
        this.dataConsulta = dataConsulta;
        this.estado = estado;
        Descricao = descricao;
    }

    public Consulta() {
    }

    public LocalDateTime getDataMarcada() {
        return dataMarcada;
    }

    public void setDataMarcada(LocalDateTime dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
