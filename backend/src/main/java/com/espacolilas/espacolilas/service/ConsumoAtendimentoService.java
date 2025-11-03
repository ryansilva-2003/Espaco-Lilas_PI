package com.espacolilas.espacolilas.service;

import com.espacolilas.espacolilas.model.ConsumoAtendimento;
import com.espacolilas.espacolilas.repository.ConsumoAtendimentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumoAtendimentoService {

    private final ConsumoAtendimentoRepository repository;

    public ConsumoAtendimentoService(ConsumoAtendimentoRepository repository) {
        this.repository = repository;
    }

    public List<ConsumoAtendimento> findAll() {
        return repository.findAll();
    }

    public Optional<ConsumoAtendimento> findById(Integer id) {
        return repository.findById(id);
    }

    public ConsumoAtendimento save(ConsumoAtendimento consumo) {
        return repository.save(consumo);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
