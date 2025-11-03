package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.model.ConsumoAtendimento;
import com.espacolilas.espacolilas.service.ConsumoAtendimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo")
public class ConsumoAtendimentoController {

    private final ConsumoAtendimentoService service;

    public ConsumoAtendimentoController(ConsumoAtendimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConsumoAtendimento> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoAtendimento> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ConsumoAtendimento create(@RequestBody ConsumoAtendimento consumo) {
        return service.save(consumo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoAtendimento> update(@PathVariable Integer id, @RequestBody ConsumoAtendimento consumo) {
        return service.findById(id)
                .map(existing -> {
                    existing.setAgendamento(consumo.getAgendamento());
                    existing.setProduto(consumo.getProduto());
                    existing.setQtdeUsada(consumo.getQtdeUsada());
                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (service.findById(id).isPresent()) {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
