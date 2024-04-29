package br.com.luds.Luds.tipopagamento.service;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.tipopagamento.exception.TipoPagamentoNaoEncontradaException;
import br.com.luds.Luds.tipopagamento.model.TipoPagamento;
import br.com.luds.Luds.tipopagamento.repository.TipoPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TipoPagamentoService {

    private final TipoPagamentoRepository tipoPagamentoRepository;

    public TipoPagamento buscarTipoPagamentoPorId(UUID id) {
        if(Objects.isNull(id)) {
            throw new TipoPagamentoNaoEncontradaException();
        }
        return this.tipoPagamentoRepository.findById(id).orElseThrow(() -> new TipoPagamentoNaoEncontradaException());
    }

    public Page<TipoPagamento> listarTipoPagamentos(ApiPageRequest pageRequest) {
        return this.tipoPagamentoRepository.findAllOrderedByNomeAsc(pageRequest.setPage());
    }

    public TipoPagamento inserirTipoPagamento(TipoPagamento tipoPagamento) {
        return this.tipoPagamentoRepository.save(tipoPagamento);
    }

    public TipoPagamento alterarTipoPagamento(UUID id, TipoPagamento tipoPagamento) {
        TipoPagamento tipoPagamentoTipoPagamentoAtualizade = this.buscarTipoPagamentoPorId(id);
        tipoPagamentoTipoPagamentoAtualizade.atualiza(tipoPagamento);
        return this.tipoPagamentoRepository.save(tipoPagamentoTipoPagamentoAtualizade);
    }

    public void removerTipoPagamento(UUID id) {
        TipoPagamento tipoPagamento = this.buscarTipoPagamentoPorId(id);
        this.tipoPagamentoRepository.delete(tipoPagamento);
    }
}
