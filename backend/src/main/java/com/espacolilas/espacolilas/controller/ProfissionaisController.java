package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.model.Profissionais;
import com.espacolilas.espacolilas.service.ProfissionaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping("/buscar")
    public ResponseEntity<List<Profissionais>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(profissionaisService.buscarPorNome(nome));
    }

    // Criar profissional via JSON
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Profissionais> criarJson(@RequestBody Profissionais profissionais) {
        return ResponseEntity.ok(profissionaisService.salvar(profissionais));
    }

    // Criar profissional via modal
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Profissionais> criarForm(@ModelAttribute Profissionais profissionais) {
        return ResponseEntity.ok(profissionaisService.salvar(profissionais));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestParam String cpf, @RequestParam String senha) {
        Profissionais profissionais = profissionaisService.buscarPorCpf(cpf);

        if (profissionais == null) {
            return ResponseEntity.status(401).body("CPF não encontrado");
        }

        // Verifica senha com BCrypt
        boolean senhaCorreta = new BCryptPasswordEncoder().matches(senha, profissionais.getSenha());

        if (!senhaCorreta) {
            return ResponseEntity.status(401).body("Senha incorreta");
        }

        return ResponseEntity.ok("Login realizado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissionais> atualizar(@PathVariable Integer id, @RequestBody Profissionais profissionais) {
        return ResponseEntity.ok(profissionaisService.atualizar(id, profissionais));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        profissionaisService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

