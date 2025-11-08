package com.espacolilas.espacolilas.service;

import com.espacolilas.espacolilas.model.Paciente;
import com.espacolilas.espacolilas.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    public List<Paciente> buscarPorNome(String nome) {
        return pacienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Paciente salvar(Paciente paciente) {
        if (pacienteRepository.existsByCpf(paciente.getCpf())) {
            throw new RuntimeException("Este cpf já está cadastrado.");
        }
        return pacienteRepository.save(paciente);
    }

    public Paciente atualizar(Integer id, Paciente dadosAtualizados) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        paciente.setNome(dadosAtualizados.getNome());
        paciente.setEmail(dadosAtualizados.getEmail());
        paciente.setTelefone(dadosAtualizados.getTelefone());
        paciente.setData_nascimento(dadosAtualizados.getData_nascimento());
        paciente.setSexo(dadosAtualizados.getSexo());
        paciente.setObservacoes(dadosAtualizados.getObservacoes());
        paciente.setCpf((dadosAtualizados.getCpf()));

        return pacienteRepository.save(paciente);
    }

    public void deletar(Integer id) {
        pacienteRepository.deleteById(id);
    }
}

