package br.com.luds.Luds.tipopagamento.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.tipopagamento.model.TipoPagamento;
import br.com.luds.Luds.tipopagamento.model.dto.TipoPagamentoDTO;
import br.com.luds.Luds.tipopagamento.model.form.TipoPagamentoForm;
import org.springframework.stereotype.Component;

@Component
public class TipoPagamentoAssembler implements ILudzAssembler<TipoPagamento, TipoPagamentoDTO, TipoPagamentoForm> {
    @Override
    public TipoPagamentoDTO assembleDTO(TipoPagamento entity) {
        return new TipoPagamentoDTO(entity.getId(), entity.getNome());
    }

    @Override
    public TipoPagamento assembleEntity(TipoPagamentoForm tipoPagamentoForm) {
        return new TipoPagamento(null, tipoPagamentoForm.getNome());
    }
}
