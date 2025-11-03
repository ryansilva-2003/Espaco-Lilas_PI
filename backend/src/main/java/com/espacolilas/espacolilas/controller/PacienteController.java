package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.model.Paciente;
import com.espacolilas.espacolilas.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public Paciente criar(@RequestBody @Valid Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Integer id, @RequestBody Paciente paciente) {
        paciente.setId(id);
        return pacienteRepository.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        pacienteRepository.deleteById(id);
    }
}

