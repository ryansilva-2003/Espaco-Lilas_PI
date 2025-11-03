package com.espacolilas.espacolilas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consumo_atendimento")
public class ConsumoAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relacionamento com Agendamento
    @ManyToOne
    @JoinColumn(name = "id_agendamento", nullable = false)
    private Agendamento agendamento;
    
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    @Column(name = "qtde_usada", nullable = false)
    private Integer qtdeUsada;

    // Construtores
    public ConsumoAtendimento() {}

    public ConsumoAtendimento(Agendamento agendamento, Produto produto, Integer qtdeUsada) {
        this.agendamento = agendamento;
        this.produto = produto;
        this.qtdeUsada = qtdeUsada;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQtdeUsada() {
        return qtdeUsada;
    }

    public void setQtdeUsada(Integer qtdeUsada) {
        this.qtdeUsada = qtdeUsada;
    }
}