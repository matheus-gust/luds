package br.com.luds.Luds.tipopagamento.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.tipopagamento.model.assembler.TipoPagamentoAssembler;
import br.com.luds.Luds.tipopagamento.model.dto.TipoPagamentoDTO;
import br.com.luds.Luds.tipopagamento.model.form.TipoPagamentoForm;
import br.com.luds.Luds.tipopagamento.service.TipoPagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TipoPagamentoApplication {

    private final TipoPagamentoService tipoPagamentoService;
    private final TipoPagamentoAssembler tipoPagamentoAssembler;

    public ApiCollectionResponse<TipoPagamentoDTO> listarTipoPagamentos(ApiPageRequest pageRequest) {
        Page pageTipoPagamento = this.tipoPagamentoService.listarTipoPagamentos(pageRequest);
        return tipoPagamentoAssembler.assembleManyDTO(pageTipoPagamento.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageTipoPagamento.hasNext());
    }

    public TipoPagamentoDTO buscarTipoPagamentoPorId(UUID id) {
        return this.tipoPagamentoAssembler.assembleDTO(this.tipoPagamentoService.buscarTipoPagamentoPorId(id));
    }

    public TipoPagamentoDTO inserirTipoPagamento(TipoPagamentoForm tipoPagamento) {
        return this.tipoPagamentoAssembler.assembleDTO(this.tipoPagamentoService.inserirTipoPagamento(this.tipoPagamentoAssembler.assembleEntity(tipoPagamento)));
    }

    public TipoPagamentoDTO alterarTipoPagamento(UUID id, TipoPagamentoForm tipoPagamento) {
        return this.tipoPagamentoAssembler.assembleDTO(this.tipoPagamentoService.alterarTipoPagamento(id, this.tipoPagamentoAssembler.assembleEntity(tipoPagamento)));
    }

    public void removerTipoPagamento(UUID id) {
        this.tipoPagamentoService.removerTipoPagamento(id);
    }
}
