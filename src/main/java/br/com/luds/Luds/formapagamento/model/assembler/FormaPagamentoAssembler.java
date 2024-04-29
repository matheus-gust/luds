package br.com.luds.Luds.formapagamento.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import br.com.luds.Luds.formapagamento.model.dto.FormaPagamentoDTO;
import br.com.luds.Luds.formapagamento.model.form.FormaPagamentoForm;
import br.com.luds.Luds.tipopagamento.model.TipoPagamento;
import br.com.luds.Luds.tipopagamento.model.assembler.TipoPagamentoAssembler;
import br.com.luds.Luds.tipopagamento.service.TipoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FormaPagamentoAssembler implements ILudzAssembler<FormaPagamento, FormaPagamentoDTO, FormaPagamentoForm> {

    @Autowired
    private TipoPagamentoAssembler tipoPagamentoAssembler;
    @Autowired
    private TipoPagamentoService tipoPagamentoService;

    @Override
    public FormaPagamentoDTO assembleDTO(FormaPagamento entity) {
        return new FormaPagamentoDTO(entity.getId(), entity.getNome(), tipoPagamentoAssembler.assembleDTO(entity.getTipoPagamento()));
    }

    @Override
    public FormaPagamento assembleEntity(FormaPagamentoForm formaPagamentoForm) {
        TipoPagamento tipopagamento = this.tipoPagamentoService.buscarTipoPagamentoPorId(formaPagamentoForm.getTipoPagamento().getId());
        return new FormaPagamento(null, formaPagamentoForm.getNome(), tipopagamento);
    }
}
