package pro.it.gestao_clinica.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Consulta {

    private LocalDateTime dataMarcada;
    private LocalDateTime dataConsulta;
    private Boolean estado;
    private String Descricao;

    @ManyToOne
    private MedicoEspecialidade medicoEspecialidade;

    @ManyToOne
    private Paciente paciente;

    @OneToOne
    private Fatura fatura;

    @ManyToOne
    private Desconto desconto;

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

    public Desconto getDesconto() {
        return desconto;
    }

    public void setDesconto(Desconto desconto) {
        desconto.addConsulta(this);
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "dataMarcada=" + dataMarcada +
                ", dataConsulta=" + dataConsulta +
                ", estado=" + estado +
                ", Descricao='" + Descricao + '\'' +
                '}';
    }
}
