package br.com.luds.Luds.unidade.service;

import br.com.luds.Luds.unidade.model.Unidade;
import br.com.luds.Luds.unidade.repository.UnidadeRepository;
import br.com.luds.Luds.unidade.exception.UnidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public Unidade buscarUnidadePorId(UUID id) {
        return this.unidadeRepository.findById(id).orElseThrow(() -> new UnidadeNaoEncontradaException());
    }

    public List<Unidade> listarUnidades() {
        return this.unidadeRepository.findAll();
    }

    public Unidade inserirUnidade(Unidade unidade) {
        return this.unidadeRepository.save(unidade);
    }

    public Unidade alterarUnidade(UUID id, Unidade unidade) {
        Unidade unidadeUnidadeAtualizade = this.buscarUnidadePorId(id);
        unidadeUnidadeAtualizade.atualiza(unidade);
        return this.unidadeRepository.save(unidade);
    }

    public void removerUnidade(UUID id) {
        Unidade unidade = this.buscarUnidadePorId(id);
        this.unidadeRepository.delete(unidade);
    }
}
