package com.espacolilas.espacolilas.controller;

import com.espacolilas.espacolilas.model.Paciente;
import com.espacolilas.espacolilas.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listar() {
        //return pacienteService.findAll();
    }

    @PostMapping
    public Paciente criar(@RequestBody @Valid Paciente paciente) {
       // return pacienteService.save(paciente);
    }

    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Integer id, @RequestBody Paciente paciente) {
        paciente.setId(id);
       // return pacienteService.save(paciente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
       // pacienteService.deleteById(id);
    }
}

