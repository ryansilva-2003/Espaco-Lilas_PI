package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.dto.LoginRequestDto;
import com.espacolilas.espacolilas.dto.ProfissionaisRequestDto;
import com.espacolilas.espacolilas.model.Profissionais;
import com.espacolilas.espacolilas.service.ProfissionaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
@CrossOrigin(origins = "https://ryansilva-2003.github.io/Espaco-Lilas_PI/")
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

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Profissionais> criar(@RequestBody ProfissionaisRequestDto dto) {

        Profissionais profissional = new Profissionais();
        profissional.setNome(dto.nome());
        profissional.setEmail(dto.email());
        profissional.setCpf(dto.cpf());
        profissional.setTelefone(dto.telefone());
        profissional.setEspecialidade(dto.especialidade());

        profissional.setSenha(dto.senha());

        return ResponseEntity.ok(profissionaisService.salvar(profissional));
    }

    // Criar profissional via modal
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Profissionais> criarForm(@ModelAttribute Profissionais profissionais) {
        return ResponseEntity.ok(profissionaisService.salvar(profissionais));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
        String cpf = loginRequestDto.cpf().trim();
        String senha = loginRequestDto.senha().trim();

        Profissionais profissionais = profissionaisService.buscarPorCpf(cpf);

        if (profissionais == null) {
            return ResponseEntity.status(401).body("CPF não encontrado");
        }

        if (!senha.equals(profissionais.getSenha())) {
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

