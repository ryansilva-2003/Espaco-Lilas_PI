package com.espacolilas.espacolilas.repository;

import com.espacolilas.espacolilas.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {
    List<Procedimento> findByNomeContainingIgnoreCase(String nome);
}

