package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.model.Profissionais;
import com.espacolilas.espacolilas.service.ProfissionaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin("*")
public class ProfissionaisController {

    private final ProfissionaisService profissionaisService;

    public ProfissionaisController(ProfissionaisService profissionaisService) {
        this.profissionaisService = profissionaisService;
    }

    @GetMapping
    public ResponseEntity<List<Profissionais>> listar() {
        return ResponseEntity.ok(profissionaisService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissionais> buscar(@PathVariable Integer id) {
        return profissionaisService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Profissionais>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(profissionaisService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Profissionais> criar(@RequestBody Profissionais profissional) {
        return ResponseEntity.ok(profissionaisService.salvar(profissional));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissionais> atualizar(@PathVariable Integer id,
                                                   @RequestBody Profissionais profissional) {
        return ResponseEntity.ok(profissionaisService.atualizar(id, profissional));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        profissionaisService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

