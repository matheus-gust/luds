package br.com.luds.Luds.contasapagar.application;

import br.com.luds.Luds.commons.ludspage.ApiPageRequest;
import br.com.luds.Luds.commons.model.ApiCollectionResponse;
import br.com.luds.Luds.contasapagar.model.assembler.ContasPagarAssembler;
import br.com.luds.Luds.contasapagar.model.dto.ContasPagarDTO;
import br.com.luds.Luds.contasapagar.model.form.ContasPagarForm;
import br.com.luds.Luds.contasapagar.model.form.MarcaContaPagoForm;
import br.com.luds.Luds.contasapagar.service.ContasPagarService;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import br.com.luds.Luds.formapagamento.service.FormaPagamentoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ContasPagarApplication {

    private final ContasPagarService contasPagarService;
    private final FormaPagamentoService formaPagamentoService;
    private final ContasPagarAssembler contasPagarAssembler;

    public ApiCollectionResponse<ContasPagarDTO> listarContasPagars(ApiPageRequest pageRequest) {
        Page pageContasPagar = this.contasPagarService.listarContasPagars(pageRequest);
        return contasPagarAssembler.assembleManyDTO(pageContasPagar.toList(), pageRequest.getPage(), pageRequest.getPageSize(), pageContasPagar.hasNext());
    }

    public ContasPagarDTO buscarContasPagarPorId(UUID id) {
        return this.contasPagarAssembler.assembleDTO(this.contasPagarService.buscarContasPagarPorId(id));
    }

    public ContasPagarDTO inserirContasPagar(ContasPagarForm contasPagar) {
        return this.contasPagarAssembler.assembleDTO(this.contasPagarService.inserirContasPagar(this.contasPagarAssembler.assembleEntity(contasPagar)));
    }

    public ContasPagarDTO alterarContasPagar(UUID id, ContasPagarForm contasPagar) {
        return this.contasPagarAssembler.assembleDTO(this.contasPagarService.alterarContasPagar(id, this.contasPagarAssembler.assembleEntity(contasPagar)));
    }

    public void removerContasPagar(UUID id) {
        this.contasPagarService.removerContasPagar(id);
    }

    public void marcaContaPago(UUID idConta, MarcaContaPagoForm marcaContaPagoForm) {
        FormaPagamento formaPagamento = this.formaPagamentoService.buscarFormaPagamentoPorId(marcaContaPagoForm.getFormaPagamento().getId());
        this.contasPagarService.marcaContaPago(idConta, formaPagamento);
    }
}
