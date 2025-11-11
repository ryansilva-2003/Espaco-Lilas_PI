package com.espacolilas.espacolilas.repository;

import com.espacolilas.espacolilas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByNomeContainingIgnoreCase(String nome);
    boolean existsByCpf(String cpf);
}
