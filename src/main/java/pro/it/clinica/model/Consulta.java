package pro.it.clinica.model;

import pro.it.clinica.model.padrao.EntidadePadrao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;

@Entity
public class Consulta extends EntidadePadrao {

    @NotNull
    private LocalDateTime dataActual;
    @NotNull
    private LocalDateTime dataConsulta;
    @NotNull
    private Boolean estado;
    @Null
    private String Descricao;

    @NotNull
    @ManyToOne
    private MedicoEspecialidade medicoEspecialidade;

    @NotNull
    @ManyToOne
    private Paciente paciente;

    @NotNull
    @OneToOne
    private Fatura fatura;

    public Consulta(LocalDateTime dataMarcada, LocalDateTime dataConsulta, String descricao) {
        this.dataActual = dataMarcada;
        this.dataConsulta = dataConsulta;
        this.estado = true;
        Descricao = descricao;
    }

    public Consulta() {
    }

    public LocalDateTime getDataMarcada() {
        return dataActual;
    }

    public void setDataMarcada(LocalDateTime dataMarcada) {
        this.dataActual = dataMarcada;
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

    public MedicoEspecialidade getMedicoEspecialidade() {
        return medicoEspecialidade;
    }

    public void setMedicoEspecialidade(MedicoEspecialidade medicoEspecialidade) {
        this.medicoEspecialidade = medicoEspecialidade;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        fatura.setConsulta(this);
        this.fatura = fatura;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "dataMarcada=" + dataActual +
                ", dataConsulta=" + dataConsulta +
                ", estado=" + estado +
                ", Descricao='" + Descricao + '\'' +
                '}';
    }
}
