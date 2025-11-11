package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.model.Procedimento;
import com.espacolilas.espacolilas.service.ProcedimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    private final ProcedimentoService procedimentoService;

    public ProcedimentoController(ProcedimentoService procedimentoService) {
        this.procedimentoService = procedimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Procedimento>> listar() {
        return ResponseEntity.ok(procedimentoService.listarTodos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Procedimento>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(procedimentoService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Procedimento> criar(@RequestBody Procedimento procedimento) {
        return ResponseEntity.ok(procedimentoService.salvar(procedimento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Procedimento> atualizar(@PathVariable Integer id, @RequestBody Procedimento procedimento) {
        return ResponseEntity.ok(procedimentoService.atualizar(id, procedimento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        procedimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
