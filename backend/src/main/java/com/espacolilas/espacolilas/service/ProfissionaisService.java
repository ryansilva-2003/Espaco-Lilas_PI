package com.espacolilas.espacolilas.service;

import com.espacolilas.espacolilas.model.Profissionais;
import com.espacolilas.espacolilas.repository.ProfissionaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionaisService {

    private final ProfissionaisRepository profissionaisRepository;

    public ProfissionaisService(ProfissionaisRepository profissionaisRepository) {
        this.profissionaisRepository = profissionaisRepository;
    }

    public List<Profissionais> listarTodos() {
        return profissionaisRepository.findAll();
    }

    public Optional<Profissionais> buscarPorId(Integer id) {
        return profissionaisRepository.findById(id);
    }

    public List<Profissionais> buscarPorNome(String nome) {
        return profissionaisRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Profissionais salvar(Profissionais profissional) {
        if (profissionaisRepository.existsByEmail(profissional.getEmail())) {
            throw new RuntimeException("Este e-mail já está cadastrado para outro profissional.");
        }
        return profissionaisRepository.save(profissional);
    }

    public Profissionais atualizar(Integer id, Profissionais dadosAtualizados) {
        Profissionais profissional = profissionaisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        profissional.setNome(dadosAtualizados.getNome());
        profissional.setEmail(dadosAtualizados.getEmail());
        profissional.setTelefone(dadosAtualizados.getTelefone());
        profissional.setEspecialidade(dadosAtualizados.getEspecialidade());
        profissional.setSalario(dadosAtualizados.getSalario());

        return profissionaisRepository.save(profissional);
    }

    public void deletar(Integer id) {
        profissionaisRepository.deleteById(id);
    }
}
