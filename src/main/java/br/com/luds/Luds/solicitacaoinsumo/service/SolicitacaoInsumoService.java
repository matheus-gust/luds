package br.com.luds.Luds.solicitacaoinsumo.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.solicitacaoinsumo.exception.SolicitacaoInsumoNaoEncontradaException;
import br.com.luds.Luds.solicitacaoinsumo.model.SolicitacaoInsumo;
import br.com.luds.Luds.solicitacaoinsumo.repository.SolicitacaoInsumoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SolicitacaoInsumoService {

    private final SolicitacaoInsumoRepository solicitacaoInsumoRepository;

    public SolicitacaoInsumo buscarSolicitacaoInsumoPorId(UUID id) {
        return this.solicitacaoInsumoRepository.findById(id).orElseThrow(() -> new SolicitacaoInsumoNaoEncontradaException());
    }

    public Page<SolicitacaoInsumo> listarSolicitacaoInsumos(ApiPageRequest pageRequest) {
        return this.solicitacaoInsumoRepository.findAll(pageRequest.setPage());
    }

    public SolicitacaoInsumo inserirSolicitacaoInsumo(SolicitacaoInsumo solicitacaoInsumo) {
        return this.solicitacaoInsumoRepository.save(solicitacaoInsumo);
    }

    public SolicitacaoInsumo alterarSolicitacaoInsumo(UUID id, SolicitacaoInsumo solicitacaoInsumo) {
        SolicitacaoInsumo unidadeSolicitacaoInsumoAtualizade = this.buscarSolicitacaoInsumoPorId(id);
        unidadeSolicitacaoInsumoAtualizade.atualiza(solicitacaoInsumo);
        return this.solicitacaoInsumoRepository.save(unidadeSolicitacaoInsumoAtualizade);
    }

    public void removerSolicitacaoInsumo(UUID id) {
        SolicitacaoInsumo solicitacaoInsumo = this.buscarSolicitacaoInsumoPorId(id);
        this.solicitacaoInsumoRepository.delete(solicitacaoInsumo);
    }
}
