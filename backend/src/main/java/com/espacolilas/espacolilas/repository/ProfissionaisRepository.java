package com.espacolilas.espacolilas.repository;

import com.espacolilas.espacolilas.model.Profissionais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionaisRepository extends JpaRepository<Profissionais, Integer> {

    List<Profissionais> findByNomeContainingIgnoreCase(String nome);
    boolean existsByCpf(String cpf);
}
