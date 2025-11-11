package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.model.Agendamentos;
import com.espacolilas.espacolilas.service.AgendamentosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentosController {

    private final AgendamentosService agendamentosService;

    public AgendamentosController(AgendamentosService agendamentosService) {
        this.agendamentosService = agendamentosService;
    }

    @GetMapping
    public ResponseEntity<List<Agendamentos>> listar() {
        return ResponseEntity.ok(agendamentosService.listarTodos());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Agendamentos>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(agendamentosService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Agendamentos> criar(@RequestBody Agendamentos agendamentos) {
        return ResponseEntity.ok(agendamentosService.salvar(agendamentos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamentos> atualizar(@PathVariable Integer id, @RequestBody Agendamentos agendamentos) {
        return ResponseEntity.ok(agendamentosService.atualizar(id, agendamentos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        agendamentosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
