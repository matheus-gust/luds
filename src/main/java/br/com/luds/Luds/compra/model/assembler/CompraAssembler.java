package br.com.luds.Luds.compra.model.assembler;

import br.com.luds.Luds.commons.model.ILudzAssembler;
import br.com.luds.Luds.compra.model.Compra;
import br.com.luds.Luds.compra.model.CompraInsumo;
import br.com.luds.Luds.compra.model.dto.CompraDTO;
import br.com.luds.Luds.compra.model.dto.CompraInsumoDTO;
import br.com.luds.Luds.compra.model.form.CompraForm;
import br.com.luds.Luds.fornecedor.model.Fornecedor;
import br.com.luds.Luds.fornecedor.model.assembler.FornecedorAssembler;
import br.com.luds.Luds.fornecedor.model.dto.FornecedorDTO;
import br.com.luds.Luds.fornecedor.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CompraAssembler implements ILudzAssembler<Compra, CompraDTO, CompraForm> {

    private final CompraInsumoAssembler compraInsumoAssembler;
    private final FornecedorAssembler fornecedorAssembler;
    private final FornecedorService fornecedorService;

    @Override
    public CompraDTO assembleDTO(Compra entity) {
        List<CompraInsumoDTO> compraInsumoDTOS = compraInsumoAssembler.assembleManyDTO(entity.getItens());
        FornecedorDTO fornecedor = fornecedorAssembler.assembleDTO(entity.getFornecedor());
        BigDecimal valorTotal = entity.getItens().stream()
                .map(item -> item.getValor().multiply(item.getQuantidade()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new CompraDTO(entity.getId(), entity.getBoletim(), entity.getData(), fornecedor, valorTotal, compraInsumoDTOS);
    }

    @Override
    public Compra assembleEntity(CompraForm compraForm) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedorPorId(compraForm.getFornecedor().getId());
        return new Compra(null, null, compraForm.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), fornecedor, new ArrayList<>());
    }
}
