package br.com.luds.Luds.formapagamento.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.formapagamento.model.assembler.FormaPagamentoAssembler;
import br.com.luds.Luds.formapagamento.model.dto.FormaPagamentoDTO;
import br.com.luds.Luds.formapagamento.model.form.FormaPagamentoForm;
import br.com.luds.Luds.formapagamento.service.FormaPagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FormaPagamentoApplication {

    private final FormaPagamentoService formaPagamentoService;
    private final FormaPagamentoAssembler formaPagamentoAssembler;

    public ApiCollectionResponse<FormaPagamentoDTO> listarFormaPagamentos(ApiPageRequest pageRequest) {
        Page pageFormaPagamento = this.formaPagamentoService.listarFormaPagamentos(pageRequest);
        return formaPagamentoAssembler.assembleManyDTO(pageFormaPagamento.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageFormaPagamento.hasNext());
    }

    public FormaPagamentoDTO buscarFormaPagamentoPorId(UUID id) {
        return this.formaPagamentoAssembler.assembleDTO(this.formaPagamentoService.buscarFormaPagamentoPorId(id));
    }

    public FormaPagamentoDTO inserirFormaPagamento(FormaPagamentoForm formaPagamento) {
        return this.formaPagamentoAssembler.assembleDTO(this.formaPagamentoService.inserirFormaPagamento(this.formaPagamentoAssembler.assembleEntity(formaPagamento)));
    }

    public FormaPagamentoDTO alterarFormaPagamento(UUID id, FormaPagamentoForm formaPagamento) {
        return this.formaPagamentoAssembler.assembleDTO(this.formaPagamentoService.alterarFormaPagamento(id, this.formaPagamentoAssembler.assembleEntity(formaPagamento)));
    }

    public void removerFormaPagamento(UUID id) {
        this.formaPagamentoService.removerFormaPagamento(id);
    }
}
