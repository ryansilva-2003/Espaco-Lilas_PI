package com.espacolilas.espacolilas.repository;

import com.espacolilas.espacolilas.model.Agendamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgendamentosRepository extends JpaRepository<Agendamentos, Integer> {

    @Query("SELECT a FROM Agendamentos a WHERE a.paciente.nome LIKE %:nome%")
    List<Agendamentos> findByPacienteNomeContainingIgnoreCase(@Param("nome") String nome);
}
