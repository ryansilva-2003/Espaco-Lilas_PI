package com.espacolilas.espacolilas.service;

import com.espacolilas.espacolilas.model.Procedimento;
import com.espacolilas.espacolilas.repository.ProcedimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentoService {

    private final ProcedimentoRepository procedimentoRepository;

    public ProcedimentoService(ProcedimentoRepository procedimentoRepository) {
        this.procedimentoRepository = procedimentoRepository;
    }

    public List<Procedimento> listarTodos() {
        return procedimentoRepository.findAll();
    }

    public List<Procedimento> buscarPorNome(String nome) {
        return procedimentoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Procedimento salvar(Procedimento procedimento) {
        return procedimentoRepository.save(procedimento);
    }

    public Procedimento atualizar(Integer id, Procedimento dadosAtualizados) {
        Procedimento procedimento = procedimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procedimento não encontrado!"));

        procedimento.setNome(dadosAtualizados.getNome());
        procedimento.setDescricao(dadosAtualizados.getDescricao());
        procedimento.setValor_base(dadosAtualizados.getValor_base());
        procedimento.setQtdeSessoes(dadosAtualizados.getQtdeSessoes());

        return procedimentoRepository.save(procedimento);
    }

    public void deletar(Integer id) {
        procedimentoRepository.deleteById(id);
    }
}
