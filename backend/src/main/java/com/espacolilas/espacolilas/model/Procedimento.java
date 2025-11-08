package com.espacolilas.espacolilas.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "procedimentos")
public class Procedimento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Integer id;

    @Column (name = "nome", length = 100, nullable = false)
    private String nome;

    @Column (name = "descricao", length = 500, nullable = false)
    private String descricao;

    @Column (name = "valor_base", nullable = false, precision = 8, scale = 2)
    private BigDecimal valor_base;

    @Column(name = "qtde_sessoes", nullable = false)
    private Integer qtdeSessoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor_base() {
        return valor_base;
    }

    public void setValor_base(BigDecimal valor_base) {
        this.valor_base = valor_base;
    }

    public Integer getQtdeSessoes() {
        return qtdeSessoes;
    }

    public void setQtdeSessoes(Integer qtdeSessoes) {
        this.qtdeSessoes = qtdeSessoes;
    }
}
