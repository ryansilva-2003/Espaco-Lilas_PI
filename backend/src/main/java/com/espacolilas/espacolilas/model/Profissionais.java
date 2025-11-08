package com.espacolilas.espacolilas.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "profissionais")
public class Profissionais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column (name = "nome", nullable = false)
    private String nome;

    @Column (name = "cpf", length = 14, nullable = false)
    private String cpf;

    @Column (name = "email", length = 100, nullable = false)
    private String email;

    @Column (name = "telefone", length = 15, nullable = false)
    private String  telefone;

    @Column (name = "especialidade", nullable = false)
    private String especialidade;

    @Column (name = "salario", nullable = false)
    private BigDecimal salario;

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

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
