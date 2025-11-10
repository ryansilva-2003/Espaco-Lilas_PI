package com.espacolilas.espacolilas.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.espacolilas.espacolilas.model.Profissionais;
import com.espacolilas.espacolilas.repository.ProfissionaisRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProfissionaisService {

    private final ProfissionaisRepository profissionaisRepository;

    public ProfissionaisService(ProfissionaisRepository profissionaisRepository) {
        this.profissionaisRepository = profissionaisRepository;
    }

    public List<Profissionais> listarTodos() {
        return profissionaisRepository.findAll();
    }

    public List<Profissionais> buscarPorNome(String nome) {
        return profissionaisRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Profissionais buscarPorCpf(String cpf) {
        return profissionaisRepository.findByCpf(cpf);
    }

    public Profissionais salvar(Profissionais profissional) {
        if (profissionaisRepository.existsByCpf(profissional.getCpf())) {
            throw new RuntimeException("Este cpf já está cadastrado!");
        }

        return profissionaisRepository.save(profissional);
    }

    public Profissionais atualizar(Integer id, Profissionais dadosAtualizados) {
        Profissionais profissionais = profissionaisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        profissionais.setNome(dadosAtualizados.getNome());
        profissionais.setEmail(dadosAtualizados.getEmail());
        profissionais.setTelefone(dadosAtualizados.getTelefone());
        profissionais.setEspecialidade(dadosAtualizados.getEspecialidade());
        profissionais.setSalario(dadosAtualizados.getSalario());

        if (dadosAtualizados.getSenha() != null && !dadosAtualizados.getSenha().isEmpty()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            profissionais.setSenha(encoder.encode(dadosAtualizados.getSenha()));

        }
        return profissionaisRepository.save(profissionais);
    }

    public void deletar(Integer id) {
        profissionaisRepository.deleteById(id);
    }
}

