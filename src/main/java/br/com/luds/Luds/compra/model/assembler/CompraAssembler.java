package br.com.luds.Luds.compra.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.compra.model.Compra;
import br.com.luds.Luds.compra.model.CompraInsumo;
import br.com.luds.Luds.compra.model.dto.CompraDTO;
import br.com.luds.Luds.compra.model.dto.CompraInsumoDTO;
import br.com.luds.Luds.compra.model.form.CompraForm;
import br.com.luds.Luds.formapagamento.model.FormaPagamento;
import br.com.luds.Luds.formapagamento.model.assembler.FormaPagamentoAssembler;
import br.com.luds.Luds.formapagamento.model.dto.FormaPagamentoDTO;
import br.com.luds.Luds.formapagamento.service.FormaPagamentoService;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.fornecedor.model.assembler.FornecedorAssembler;
import br.com.luds.Luds.fornecedor.model.dto.FornecedorDTO;
import br.com.luds.Luds.fornecedor.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompraAssembler implements ILudzAssembler<Compra, CompraDTO, CompraForm> {

    private final CompraInsumoAssembler compraInsumoAssembler;
    private final FornecedorAssembler fornecedorAssembler;
    private final FornecedorService fornecedorService;
    private final FormaPagamentoService formaPagamentoService;
    private final FormaPagamentoAssembler formaPagamentoAssembler;

    @Override
    public CompraDTO assembleDTO(Compra entity) {
        List<CompraInsumoDTO> compraInsumoDTOS = compraInsumoAssembler.assembleManyDTO(entity.getItens());
        FornecedorDTO fornecedor = fornecedorAssembler.assembleDTO(entity.getFornecedor());
        FormaPagamentoDTO formaPagamento = null;
        if(entity.getFormaPagamento() != null) {
            formaPagamento = formaPagamentoAssembler.assembleDTO(entity.getFormaPagamento());
        }
        BigDecimal valorTotal = entity.getItens().stream()
                .map(item -> item.getValor().multiply(item.getQuantidade()).subtract(item.getDesconto()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        valorTotal = valorTotal.setScale(2, RoundingMode.HALF_UP);
        return new CompraDTO(entity.getId(), entity.getBoletim(), entity.getData(), fornecedor, formaPagamento, valorTotal, compraInsumoDTOS);
    }

    @Override
    public Compra assembleEntity(CompraForm compraForm) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(compraForm.getFornecedor().getId());
        FormaPagamento formaPagamento = formaPagamentoService.buscarFormaPagamentoPorId(compraForm.getFormaPagamento().getId());
        return new Compra(null, null, compraForm.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), fornecedor, formaPagamento, new ArrayList<>());
    }
}
