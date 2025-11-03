package com.espacolilas.espacolilas.repository;

import com.espacolilas.espacolilas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
