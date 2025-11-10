package com.espacolilas.espacolilas.service;

import com.espacolilas.espacolilas.model.Agendamentos;
import com.espacolilas.espacolilas.repository.AgendamentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentosService {

    private final AgendamentosRepository agendamentosRepository;

    public AgendamentosService(AgendamentosRepository agendamentosRepository) {
        this.agendamentosRepository = agendamentosRepository;
    }

    public List<Agendamentos> listarTodos(){
        return agendamentosRepository.findAll();
    }

    public List<Agendamentos> buscarPorNome(String nome){
        return agendamentosRepository.findByPacienteNomeContainingIgnoreCase(nome);
    }

    public Agendamentos salvar(Agendamentos agendamentos) {
        return agendamentosRepository.save(agendamentos);
    }

    public Agendamentos atualizar(Integer id, Agendamentos dadosAtualizados) {
        Agendamentos agendamentos = agendamentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado!"));

        agendamentos.setData(dadosAtualizados.getData());
        agendamentos.setHora_inicio(dadosAtualizados.getHora_inicio());
        agendamentos.setHora_fim(dadosAtualizados.getHora_fim());
        agendamentos.setTipo_atendimento(dadosAtualizados.getTipo_atendimento());
        agendamentos.setObservacoes(dadosAtualizados.getObservacoes());
        agendamentos.setStatus(dadosAtualizados.getStatus());

        return agendamentosRepository.save(agendamentos);
    }

    public void deletar(Integer id) {
        agendamentosRepository.deleteById(id);
    }
}
