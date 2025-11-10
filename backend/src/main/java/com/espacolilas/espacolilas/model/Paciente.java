package com.espacolilas.espacolilas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table (name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Integer id;

    @Column (name = "nome", length = 100, nullable = false)
    private String nome;

    @Column (name = "cpf", length = 14, nullable = false)
    private String cpf;

    @Email(message = "Esse email deve ser válido")
    @Column (name = "email", length = 100, nullable = false)
    private String email;

    @Column (name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column (name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

    @Column (name = "sexo", nullable = false)
    private String sexo;

    @Column (name = "observacoes", length = 500)
    private String observacoes;

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

    public void setCpf (String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
