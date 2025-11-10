package com.espacolilas.espacolilas.model;


import jakarta.persistence.*;

@Entity
@Table (name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Integer id;

    @Column (name = "nome", length = 100, nullable = false)
    private String nome;

    @Column (name = "descricao", length = 500, nullable = false)
    private String descricao;

    @Column (name = "unidade", length = 20, nullable = false)
    private String unidade;

    @Column(name = "estoque_atual", nullable = false)
    private Integer estoqueAtual;

    @Column(name = "estoque_minimo", nullable = false)
    private Integer estoqueMinimo;

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

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Integer getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(Integer estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
}
