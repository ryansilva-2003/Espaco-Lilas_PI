package com.espacolilas.espacolilas.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "agendamentos")
public class Agendamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_agendamento", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn (name = "id_procedimento", nullable = false)
    private Procedimento procedimento;

    @ManyToOne
    @JoinColumn (name = "id_profissional", nullable = false)
    private Profissionais profissionais;

    @Column (name = "data", nullable = false)
    private LocalDate data;

    @Column (name = "hora_inicio", nullable = false)
    private LocalTime hora_inicio;

    @Column (name = "hora_fim", nullable = false)
    private LocalTime hora_fim;

    @Column (name = "tipo_atendimento", length = 100, nullable = false)
    private String tipo_atendimento;

    @Column (name = "etapa_atendimento", length = 100)
    private String etapa_atendimento;

    @Column (name = "observacoes", length = 100)
    private String observacoes;

    @Column (name = "status", length = 100, nullable = false)
    private String status = "agendado";

    @Column (name = "valor", nullable = false)
    private BigDecimal valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento(){
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento){
        this.procedimento = procedimento;
    }

    public Profissionais getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(Profissionais profissionais) {
        this.profissionais = profissionais;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(LocalTime hora_fim) {
        this.hora_fim = hora_fim;
    }

    public String getTipo_atendimento() {
        return tipo_atendimento;
    }

    public void setTipo_atendimento(String tipo_atendimento) {
        this.tipo_atendimento = tipo_atendimento;
    }

    public String getEtapa_atendimento() {
        return etapa_atendimento;
    }

    public void setEtapa_atendimento(String etapa_atendimento) {
        this.etapa_atendimento = etapa_atendimento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getValor (){
        return valor;
    }

    public void setValor(BigDecimal valor){
        this.valor = valor;
    }
}
