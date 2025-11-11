package com.espacolilas.espacolilas.model;


import jakarta.persistence.*;

@Entity
@Table (name = "consumo_atendimento")
public class Consumo_atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn (name = "id_agendamento")
    private Agendamentos agendamentos;

    @ManyToOne
    @JoinColumn (name = "id_produto")
    private Produto produto;

    @Column (name = "qtde_usada", length = 11, nullable = false)
    private Integer qtde_usada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Agendamentos getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Agendamentos agendamentos) {
        this.agendamentos = agendamentos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQtde_usada() {
        return qtde_usada;
    }

    public void setQtde_usada(Integer qtde_usada) {
        this.qtde_usada = qtde_usada;
    }
}
