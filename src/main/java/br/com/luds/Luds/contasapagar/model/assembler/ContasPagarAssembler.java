package br.com.luds.Luds.contasapagar.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.contasapagar.model.ContasPagar;
import br.com.luds.Luds.contasapagar.model.dto.ContasPagarDTO;
import br.com.luds.Luds.contasapagar.model.form.ContasPagarForm;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import br.com.luds.Luds.formapagamento.model.assembler.FormaPagamentoAssembler;
import br.com.luds.Luds.formapagamento.model.dto.FormaPagamentoDTO;
import br.com.luds.Luds.formapagamento.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ContasPagarAssembler implements ILudzAssembler<ContasPagar, ContasPagarDTO, ContasPagarForm> {

    @Autowired
    private FormaPagamentoAssembler formaPagamentoAssembler;
    @Autowired
    private FormaPagamentoService formaPagamentoService;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public ContasPagarDTO assembleDTO(ContasPagar entity) {
        FormaPagamentoDTO formaPagamento = null;
        if(entity.getFormaPagamento() != null) {
            formaPagamento = formaPagamentoAssembler.assembleDTO(entity.getFormaPagamento());
        }
        return new ContasPagarDTO(entity.getId(), entity.getNome(), entity.getValor(), entity.getPago(), entity.getDataVencimento(), formaPagamento);
    }

    @Override
    public ContasPagar assembleEntity(ContasPagarForm contasPagarForm) {
        return new ContasPagar(contasPagarForm.getNome(), contasPagarForm.getValor(), contasPagarForm.getDataVencimento().format(formatter), null);
    }
}
