package com.espacolilas.espacolilas.repository;

import com.espacolilas.espacolilas.model.ConsumoAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoAtendimentoRepository extends JpaRepository<ConsumoAtendimento, Integer> {
}
